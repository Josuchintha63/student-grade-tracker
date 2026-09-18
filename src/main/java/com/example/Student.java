package com.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private List<Double> marks;

    public Student(String studentId, String name) {
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
        // BUG: Accepts negative marks and values > 100 without validation
        this.marks.add(mark);
    }

    // BUG: Division by zero when marks list is empty
    public double calculateAverage() {
        double sum = 0;
        for (double m : marks) {
            sum += m;
        }
        return sum / marks.size();
    }

    // BUG: Flawed grade calculation thresholds
    public String getLetterGrade() {
        double avg = calculateAverage();
        if (avg > 90) return "A";
        if (avg > 80) return "B";
        if (avg > 70) return "C";
        if (avg > 60) return "D";
        return "F";
    }
}
