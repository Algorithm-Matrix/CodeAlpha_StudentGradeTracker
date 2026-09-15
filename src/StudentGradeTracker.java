import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        System.out.println("=== CodeAlpha: Student Grade Tracker ===");
        System.out.print("Enter total number of students to add: ");
        int totalStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input Student Details
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\n--- Entering details for Student " + (i + 1) + " ---");
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            double grade;
            while (true) {
                System.out.print("Enter Grade (0 - 100): ");
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (grade >= 0 && grade <= 100) {
                        break;
                    }
                } else {
                    scanner.next(); // Clear invalid input
                }
                System.out.println("Invalid input! Please enter a numerical grade between 0 and 100.");
            }

            studentList.add(new Student(name, grade));
        }

        // Processing & Summary Calculation
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        double totalSum = 0;
        double highestGrade = studentList.get(0).grade;
        double lowestGrade = studentList.get(0).grade;

        String topStudent = studentList.get(0).name;
        String lowestStudent = studentList.get(0).name;

        for (Student s : studentList) {
            totalSum += s.grade;

            if (s.grade > highestGrade) {
                highestGrade = s.grade;
                topStudent = s.name;
            }

            if (s.grade < lowestGrade) {
                lowestGrade = s.grade;
                lowestStudent = s.name;
            }
        }

        double averageGrade = totalSum / studentList.size();

        // Output Summary Report
        System.out.println("\n=================================");
        System.out.println("     STUDENT GRADE SUMMARY       ");
        System.out.println("=================================");
        for (Student s : studentList) {
            System.out.printf("Name: %-15s | Grade: %.2f\n", s.name, s.grade);
        }
        System.out.println("---------------------------------");
        System.out.printf("Average Score : %.2f\n", averageGrade);
        System.out.printf("Highest Score : %.2f (Student: %s)\n", highestGrade, topStudent);
        System.out.printf("Lowest Score  : %.2f (Student: %s)\n", lowestGrade, lowestStudent);
        System.out.println("=================================");

        scanner.close();
    }
}