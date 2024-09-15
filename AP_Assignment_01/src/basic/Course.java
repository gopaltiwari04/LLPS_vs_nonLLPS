/*
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
    private List<String> enrolledStudents;

    // Constructor to initialize the course
    public Course(String code, String title, String professor, int credits, List<String> prerequisites, int semester) {
        this.code = code;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.available = true;  // Default value: the course is available
        this.semester = semester;
        this.grade = -1; // Default grade (not assigned yet)
        this.classTimings=classTimings;
        this.location=location;
        this.enrolledStudents = new ArrayList<>();
    }


    //private String classTimings;
    //private String location;

    // Update the constructor to include these fields
    public Course(String code, String title, String professor, int credits, List<String> prerequisites, int semester, String classTimings, String location) {
        this.code = code;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.available = true;
        this.semester = semester;
        this.grade = -1;
        this.classTimings = classTimings;
        this.location = location;
    }

    //public <E> Course(String cs101, String ip, String s, int i, ArrayList<E> es, int i1, String s1) {
    //}

    public <E> Course(String cs101, String ip, String s, int i, ArrayList<E> es, int i1, String s1, String s2, List<Student> studentList) {
    }

    // Add getters for class timings and location


    public void setClassTimings(String classTimings) {
        this.classTimings = classTimings;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClassTimings() {
        return classTimings;
    }

    public String getLocation() {
        return location;
    }

    // Getter for grade
    public double getGrade() {
        return grade;
    }

    // Method to set the grade for the course
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Getter for availability
    public boolean isAvailable() {
        return available;
    }

    // Setter for availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Method to remove a student from the course
    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    // Method to get the list of enrolled students
    public Student[] getEnrolledStudents() {
        return enrolledStudents.toArray(new Student[0]);  // Return as an array
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

    // Getter for credits
    public int getCredits() {
        return credits;
    }

    // Getter for the semester
    public int getSemester() {
        return semester;
    }

    // Getter for the course name/title
    public String getName() {
        return title;
    }

    // Getter for course code
    public String getCode() {
        return code;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public String getProfessor() {
        return professor;
    }

    public Student[] getEnrolledStudents() {
        return EnrolledStudents();
    }

    public void setSyllabus(String s) {
    }

    public void setTiming(String s) {
    }

    public void setCredits(int i) {
    }


    // Optionally, you could add more setters or other methods if needed.
}

*/


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
    private List<Student> enrolledStudents; // Changed type to List<Student>

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

    public String getProfessor() {
        return professor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
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

    // Optionally, you could add more setters or other methods if needed.
}


