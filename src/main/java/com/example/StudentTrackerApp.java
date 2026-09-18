package com.example;

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
            System.out.println("\nStudent: " + student.getName() + " (" + student.getStudentId() + ")");
            System.out.println("1. Add Subject Mark");
            System.out.println("2. View All Marks");
            System.out.println("3. View Average & Letter Grade");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Enter subject mark (0-100): ");
                    try {
                        double mark = Double.parseDouble(scanner.nextLine());
                        student.addMark(mark);
                        System.out.println("Mark added successfully!");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid numeric value.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Marks recorded: " + student.getMarks());
                    break;
                case "3":
                    try {
                        double avg = student.calculateAverage();
                        String grade = student.getLetterGrade();
                        System.out.printf("Average Mark: %.2f | Final Grade: %s%n", avg, grade);
                    } catch (Exception e) {
                        System.out.println("Error calculating grades: " + e.getMessage());
                    }
                    break;
                case "4":
                    System.out.println("Exiting Student Grade Tracker. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
        scanner.close();
    }
}
