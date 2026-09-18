# Student Grade Tracker

A simple Java 21 console application for recording student grades, computing average scores, and determining letter grades.

---

## Requirements
- Java 21+
- Apache Maven 3.8+

---

## How to Build & Run
```bash
# Compile and package
mvn clean compile

# Run the console application
mvn exec:java
```

---

## Running Tests
```bash
mvn test
```

---

## Issue Tracking & Git Workflow

### Jira Ticket: [CJ-2](https://chinthajyoshna.atlassian.net/browse/CJ-2)
- **Issue Key**: `CJ-2`
- **Summary**: Fix Student Grade Average calculation and GPA grade boundary bug
- **Status**: Resolved / In Progress
- **Branch**: `CJ-2` & `CJ-123`

### Commit History for CJ-2:
1. `test(CJ-2): add unit tests reproducing average calculation on empty list and invalid mark validation`
2. `fix(CJ-2): implement strict score range validation (0-100) in Student model`
3. `fix(CJ-2): resolve divide by zero in average calculation and correct letter grade boundary logic`
4. `refactor(CJ-2): enhance console CLI user interface with formatted summary table`
5. `docs(CJ-2): update README with bug resolution details, test results, and Jira ticket CJ-2`

---

## GitHub Repository
- **Owner**: [Josuchintha63](https://github.com/Josuchintha63)
- **Repository**: [https://github.com/Josuchintha63/student-grade-tracker](https://github.com/Josuchintha63/student-grade-tracker)
