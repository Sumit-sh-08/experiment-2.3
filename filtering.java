import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;
    Student(String name, double marks) { this.name = name; this.marks = marks; }
}

public class StudentStream {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 80),
            new Student("Bob", 70),
            new Student("Charlie", 90)
        );

        List<String> filteredNames = students.stream()
            .filter(s -> s.marks > 75)
            .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks))
            .map(s -> s.name)
            .toList();

        System.out.println("Students with marks > 75: " + filteredNames);
    }
}
