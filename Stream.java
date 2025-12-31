import java.util.*;
import java.util.stream.*;

public class Stream {

   static class Student {
      String name;
      int marks;
      String dept;

      Student(String name, int marks, String dept) {
         this.name = name;
         this.marks = marks;
         this.dept = dept;
      }

      String getName() {
         return name;
      }

      int getMarks() {
         return marks;
      }

      String getDept() {
         return dept;
      }
   }

   public static void main(String[] args) {

      /*
       * ===============================
       * 1. SOURCE
       * ===============================
       */
      List<Integer> numbers = Arrays.asList(5, 10, 20, 10, 30, 40, 5);

      /*
       * ===============================
       * 2. FILTER + DISTINCT
       * ===============================
       */
      System.out.println("Filter (>10) & Distinct:");
      numbers.stream()
            .filter(n -> n > 10)
            .distinct()
            .forEach(System.out::println);

      /*
       * ===============================
       * 3. MAP
       * ===============================
       */
      System.out.println("\nMap (square):");
      numbers.stream()
            .map(n -> n * n)
            .forEach(System.out::println);

      /*
       * ===============================
       * 4. SORTED
       * ===============================
       */
      System.out.println("\nSorted Descending:");
      numbers.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);

      /*
       * ===============================
       * 5. LIMIT & SKIP
       * ===============================
       */
      System.out.println("\nLimit 3:");
      numbers.stream().limit(3).forEach(System.out::println);

      System.out.println("\nSkip 2:");
      numbers.stream().skip(2).forEach(System.out::println);

      /*
       * ===============================
       * 6. REDUCE
       * ===============================
       */
      int sum = numbers.stream()
            .reduce(0, Integer::sum);
      System.out.println("\nSum using reduce: " + sum);

      /*
       * ===============================
       * 7. MIN / MAX / COUNT
       * ===============================
       */
      int max = numbers.stream().max(Integer::compareTo).get();
      long count = numbers.stream().count();

      System.out.println("Max: " + max);
      System.out.println("Count: " + count);

      /*
       * ===============================
       * 8. OPTIONAL (findFirst)
       * ===============================
       */
      int firstEven = numbers.stream()
            .filter(n -> n % 2 == 0)
            .findFirst()
            .orElse(-1);
      System.out.println("First Even: " + firstEven);

      /*
       * ===============================
       * 9. MATCH OPERATIONS
       * ===============================
       */
      System.out.println("Any > 50? " +
            numbers.stream().anyMatch(n -> n > 50));

      System.out.println("All positive? " +
            numbers.stream().allMatch(n -> n > 0));

      /*
       * ===============================
       * 10. FLATMAP
       * ===============================
       */
      List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));

      System.out.println("\nFlatMap result:");
      listOfLists.stream()
            .flatMap(List::stream)
            .forEach(System.out::println);

      /*
       * ===============================
       * 11. COLLECTORS – toList
       * ===============================
       */
      List<Integer> evenList = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());

      System.out.println("\nCollected Even List: " + evenList);

      /*
       * ===============================
       * 12. FREQUENCY COUNT
       * ===============================
       */
      Map<Integer, Long> freq = numbers.stream()
            .collect(Collectors.groupingBy(
                  n -> n,
                  Collectors.counting()));

      System.out.println("\nFrequency Map: " + freq);

      /*
       * ===============================
       * 13. STUDENT STREAM EXAMPLES
       * ===============================
       */
      List<Student> students = Arrays.asList(
            new Student("Alice", 85, "CSE"),
            new Student("Bob", 92, "ECE"),
            new Student("Charlie", 85, "CSE"),
            new Student("David", 95, "EEE"));

      /* Sort by marks desc, then name */
      System.out.println("\nSorted Students:");
      students.stream()
            .sorted(Comparator.comparing(Student::getMarks)
                  .reversed()
                  .thenComparing(Student::getName))
            .forEach(s -> System.out.println(s.name + " " + s.marks));

      /*
       * ===============================
       * 14. GROUPING BY
       * ===============================
       */
      Map<String, List<Student>> deptMap = students.stream()
            .collect(Collectors.groupingBy(Student::getDept));

      System.out.println("\nGrouped by Department:");
      deptMap.forEach((k, v) -> System.out.println(k + " -> " + v.size()));

      /*
       * ===============================
       * 15. SUMMING
       * ===============================
       */
      int totalMarks = students.stream()
            .collect(Collectors.summingInt(Student::getMarks));

      System.out.println("Total Marks: " + totalMarks);

      /*
       * ===============================
       * 16. PARTITIONING
       * ===============================
       */
      Map<Boolean, List<Student>> passFail = students.stream()
            .collect(Collectors.partitioningBy(s -> s.marks >= 90));

      System.out.println("\nPassed (>=90): " + passFail.get(true).size());
      System.out.println("Others: " + passFail.get(false).size());

      /*
       * ===============================
       * 17. PRIMITIVE STREAM
       * ===============================
       */
      int rangeSum = IntStream.rangeClosed(1, 5).sum();
      System.out.println("\nRange Sum (1–5): " + rangeSum);

      /*
       * ===============================
       * 18. PARALLEL STREAM
       * ===============================
       */
      int parallelSum = numbers.parallelStream().reduce(0, Integer::sum);
      System.out.println("Parallel Sum: " + parallelSum);

      /*
       * ===============================
       * 19. PEEK (Debug)
       * ===============================
       */
      System.out.println("\nPeek Debug:");
      numbers.stream()
            .peek(n -> System.out.println("Before filter: " + n))
            .filter(n -> n > 20)
            .peek(n -> System.out.println("After filter: " + n))
            .forEach(n -> {
            });
   }
}
