import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // =========================
    // Student Class
    // =========================
    static class Student {

        private String name;
        private String rollNumber;
        private double[] marks;

        // Constructor
        public Student(String name, String rollNumber, double[] marks) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.marks = marks;
        }

        // Calculate total marks
        public double getTotalMarks() {

            double total = 0;

            for (double mark : marks) {
                total += mark;
            }

            return total;
        }

        // Calculate average
        public double calculateAverage() {

            return getTotalMarks() / marks.length;
        }

        // Find highest mark
        public double getHighestMark() {

            double highest = marks[0];

            for (double mark : marks) {

                if (mark > highest) {
                    highest = mark;
                }
            }

            return highest;
        }

        // Find lowest mark
        public double getLowestMark() {

            double lowest = marks[0];

            for (double mark : marks) {

                if (mark < lowest) {
                    lowest = mark;
                }
            }

            return lowest;
        }

        // Calculate grade
        public String getGrade() {

            double average = calculateAverage();

            if (average >= 90) {
                return "A+";
            } else if (average >= 80) {
                return "A";
            } else if (average >= 70) {
                return "B";
            } else if (average >= 60) {
                return "C";
            } else if (average >= 50) {
                return "D";
            } else {
                return "F";
            }
        }

        // Get student name
        public String getName() {
            return name;
        }

        // Get roll number
        public String getRollNumber() {
            return rollNumber;
        }
    }


    // =========================
    // Main Program
    // =========================

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Student> students = new ArrayList<>();


    public static void main(String[] args) {

        int choice;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("        STUDENT GRADE TRACKER");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Statistics");
            System.out.println("5. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    calculateStatistics();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice!");
                    System.out.println("Please enter a number between 1 and 5.");
            }

        } while (choice != 5);

        scanner.close();
    }


    // =========================
    // Add Student
    // =========================

    public static void addStudent() {

        scanner.nextLine();

        System.out.println();
        System.out.println("========== ADD STUDENT ==========");

        // Student Name
        System.out.print("Enter student name: ");

        String name = scanner.nextLine();

        // Roll Number
        System.out.print("Enter roll number: ");

        String rollNumber = scanner.next();

        // Check duplicate roll number
        for (Student student : students) {

            if (student.getRollNumber().equalsIgnoreCase(rollNumber)) {

                System.out.println();
                System.out.println("Error: Roll number already exists!");

                return;
            }
        }

        // Create marks array
        double[] marks = new double[3];

        // Enter marks
        for (int i = 0; i < 3; i++) {

            while (true) {

                System.out.print(
                        "Enter marks for Subject " + (i + 1) + ": "
                );

                double mark = scanner.nextDouble();

                if (mark >= 0 && mark <= 100) {

                    marks[i] = mark;

                    break;

                } else {

                    System.out.println(
                            "Invalid marks! Enter marks between 0 and 100."
                    );
                }
            }
        }

        // Create Student object
        Student student =
                new Student(name, rollNumber, marks);

        // Add to ArrayList
        students.add(student);

        System.out.println();
        System.out.println("Student added successfully!");
    }


    // =========================
    // View All Students
    // =========================

    public static void viewAllStudents() {

        if (students.isEmpty()) {

            System.out.println();
            System.out.println("No students found.");

            return;
        }

        System.out.println();
        System.out.println("========== ALL STUDENTS ==========");

        for (Student student : students) {

            System.out.println();

            System.out.println(
                    "Name        : " + student.getName()
            );

            System.out.println(
                    "Roll Number : " + student.getRollNumber()
            );

            System.out.printf(
                    "Total Marks : %.2f%n",
                    student.getTotalMarks()
            );

            System.out.printf(
                    "Average     : %.2f%n",
                    student.calculateAverage()
            );

            System.out.printf(
                    "Highest Mark: %.2f%n",
                    student.getHighestMark()
            );

            System.out.printf(
                    "Lowest Mark : %.2f%n",
                    student.getLowestMark()
            );

            System.out.println(
                    "Grade       : " + student.getGrade()
            );

            System.out.println("----------------------------------");
        }
    }


    // =========================
    // Search Student
    // =========================

    public static void searchStudent() {

        if (students.isEmpty()) {

            System.out.println();
            System.out.println("No students available to search.");

            return;
        }

        System.out.println();
        System.out.println("========== SEARCH STUDENT ==========");

        System.out.print("Enter roll number: ");

        String rollNumber = scanner.next();

        boolean found = false;

        for (Student student : students) {

            if (student.getRollNumber()
                    .equalsIgnoreCase(rollNumber)) {

                System.out.println();
                System.out.println("Student Found!");
                System.out.println("----------------------------------");

                System.out.println(
                        "Name        : " + student.getName()
                );

                System.out.println(
                        "Roll Number : " + student.getRollNumber()
                );

                System.out.printf(
                        "Total Marks : %.2f%n",
                        student.getTotalMarks()
                );

                System.out.printf(
                        "Average     : %.2f%n",
                        student.calculateAverage()
                );

                System.out.printf(
                        "Highest Mark: %.2f%n",
                        student.getHighestMark()
                );

                System.out.printf(
                        "Lowest Mark : %.2f%n",
                        student.getLowestMark()
                );

                System.out.println(
                        "Grade       : " + student.getGrade()
                );

                System.out.println("----------------------------------");

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println();
            System.out.println("Student not found.");
        }
    }


    // =========================
    // Calculate Statistics
    // =========================

    public static void calculateStatistics() {

        if (students.isEmpty()) {

            System.out.println();
            System.out.println("No student data available.");

            return;
        }

        double totalClassAverage = 0;

        double highestAverage =
                students.get(0).calculateAverage();

        double lowestAverage =
                students.get(0).calculateAverage();

        String highestStudent =
                students.get(0).getName();

        String lowestStudent =
                students.get(0).getName();


        // Calculate statistics
        for (Student student : students) {

            double average =
                    student.calculateAverage();

            totalClassAverage += average;


            // Highest average
            if (average > highestAverage) {

                highestAverage = average;

                highestStudent =
                        student.getName();
            }


            // Lowest average
            if (average < lowestAverage) {

                lowestAverage = average;

                lowestStudent =
                        student.getName();
            }
        }


        // Class average
        double classAverage =
                totalClassAverage / students.size();


        // Display statistics
        System.out.println();
        System.out.println("========== STATISTICS ==========");

        System.out.printf(
                "Class Average   : %.2f%n",
                classAverage
        );

        System.out.printf(
                "Highest Average : %s (%.2f)%n",
                highestStudent,
                highestAverage
        );

        System.out.printf(
                "Lowest Average  : %s (%.2f)%n",
                lowestStudent,
                lowestAverage
        );

        System.out.println(
                "Total Students  : " + students.size()
        );

        System.out.println("================================");
    }
}
