package com.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private List<Double> marks;

    public Student(String studentId, String name) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty.");
        }
        this.studentId = studentId;
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Double> getMarks() {
        return new ArrayList<>(marks);
    }

    public void addMark(double mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException(
                String.format("Mark must be between 0.0 and 100.0. Provided: %.2f", mark)
            );
        }
        this.marks.add(mark);
    }

    public double calculateAverage() {
        if (marks.isEmpty()) {
            throw new IllegalStateException("No marks available to calculate average.");
        }
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.size();
    }

    public String getLetterGrade() {
        double avg = calculateAverage();
        if (avg >= 90.0) return "A";
        if (avg >= 80.0) return "B";
        if (avg >= 70.0) return "C";
        if (avg >= 60.0) return "D";
        return "F";
    }
}
