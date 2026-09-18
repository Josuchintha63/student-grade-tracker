package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("STU-101", "Jyoshna Chintha");
    }

    @Test
    @DisplayName("Should add valid marks properly")
    void testAddValidMarks() {
        student.addMark(95.0);
        student.addMark(85.0);
        assertEquals(2, student.getMarks().size());
        assertEquals(90.0, student.calculateAverage(), 0.001);
    }

    @Test
    @DisplayName("Should throw exception when adding negative marks")
    void testRejectNegativeMarks() {
        assertThrows(IllegalArgumentException.class, () -> student.addMark(-10.0));
    }

    @Test
    @DisplayName("Should throw exception when adding marks greater than 100")
    void testRejectExcessiveMarks() {
        assertThrows(IllegalArgumentException.class, () -> student.addMark(105.0));
    }

    @Test
    @DisplayName("Should throw exception when calculating average on empty marks")
    void testAverageOnEmptyList() {
        Exception exception = assertThrows(IllegalStateException.class, () -> student.calculateAverage());
        assertTrue(exception.getMessage().contains("No marks available"));
    }

    @Test
    @DisplayName("Should correctly evaluate letter grade boundary at exactly 90, 80, 70, 60")
    void testLetterGradesBoundary() {
        student.addMark(90.0);
        assertEquals("A", student.getLetterGrade()); // 90.0 should be A

        Student studentB = new Student("STU-102", "Alex");
        studentB.addMark(80.0);
        assertEquals("B", studentB.getLetterGrade()); // 80.0 should be B

        Student studentC = new Student("STU-103", "Sam");
        studentC.addMark(70.0);
        assertEquals("C", studentC.getLetterGrade()); // 70.0 should be C

        Student studentD = new Student("STU-104", "Taylor");
        studentD.addMark(60.0);
        assertEquals("D", studentD.getLetterGrade()); // 60.0 should be D

        Student studentF = new Student("STU-105", "Jordan");
        studentF.addMark(55.0);
        assertEquals("F", studentF.getLetterGrade());
    }
}
