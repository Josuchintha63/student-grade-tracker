package com.example;

import java.util.List;
import java.util.Scanner;

public class StudentTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("     Student Grade Tracker Console       ");
        System.out.println("=========================================");

        Student student = new Student("STU-101", "Jyoshna Chintha");

        boolean running = true;
        while (running) {
            System.out.println("\n-----------------------------------------");
            System.out.println("Student: " + student.getName() + " (" + student.getStudentId() + ")");
            System.out.println("-----------------------------------------");
            System.out.println("1. Add Subject Mark");
            System.out.println("2. View All Recorded Marks");
            System.out.println("3. Generate Academic Performance Report");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Enter subject mark (0-100): ");
                    try {
                        double mark = Double.parseDouble(scanner.nextLine());
                        student.addMark(mark);
                        System.out.printf("Success: Mark %.2f recorded!%n", mark);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid numeric value.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Validation Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    List<Double> marks = student.getMarks();
                    if (marks.isEmpty()) {
                        System.out.println("No marks recorded yet.");
                    } else {
                        System.out.println("Recorded Marks (" + marks.size() + " total): " + marks);
                    }
                    break;
                case "3":
                    try {
                        double avg = student.calculateAverage();
                        String grade = student.getLetterGrade();
                        System.out.println("\n===== ACADEMIC REPORT =====");
                        System.out.println("Student Name : " + student.getName());
                        System.out.println("Student ID   : " + student.getStudentId());
                        System.out.printf("Average Score: %.2f / 100.0%n", avg);
                        System.out.println("Letter Grade : " + grade);
                        System.out.println("Status       : " + ("F".equals(grade) ? "NEEDS IMPROVEMENT" : "PASSED"));
                        System.out.println("===========================");
                    } catch (IllegalStateException e) {
                        System.out.println("Warning: " + e.getMessage());
                    }
                    break;
                case "4":
                    System.out.println("Thank you for using Student Grade Tracker. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
        scanner.close();
    }
}
