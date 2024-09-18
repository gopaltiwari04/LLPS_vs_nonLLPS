package basic;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String title;
    private double grade;
    private String professor;
    private int credits;
    private List<String> prerequisites;  // List of course codes as prerequisites
    private boolean available;
    private int semester;
    private String classTimings;
    private String location;
    private static List<Student> enrolledStudents; // Changed type to List<Student>

    // Constructor to initialize the course with all fields
    public Course(String code, String title, String professor, int credits, List<String> prerequisites, int semester, String classTimings, String location, List<Student> studentList) {
        this.code = code;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.available = true;  // Default value: the course is available
        this.semester = semester;
        this.grade = -1; // Default grade (not assigned yet)
        this.classTimings = classTimings;
        this.location = location;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters and setters
    public String getClassTimings() {
        return classTimings;
    }

    public void setClassTimings(String classTimings) {
        this.classTimings = classTimings;
    }

    public String getLocation() {
        return location;
    }



    public void setLocation(String location) {
        this.location = location;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSemester() {
        return semester;
    }

    public String getName() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getProfessor() {
        return professor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public static void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    // Method to check if prerequisites are met
    public boolean prerequisitesMet(List<Course> completedCourses) {
        for (String prerequisite : prerequisites) {
            boolean found = false;
            for (Course completedCourse : completedCourses) {
                if (completedCourse.getCode().equals(prerequisite) && completedCourse.getGrade() >= 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;  // Prerequisite not met
            }
        }
        return true;  // All prerequisites met
    }

    @Override
    public String toString() {
        return "Course Name: " + title + ", Code: " + code + ", Professor: " + professor;
    }

    public String getCourseCode() {
        return code;
    }

    public String getCourseTitle() {
        return title;
    }
}