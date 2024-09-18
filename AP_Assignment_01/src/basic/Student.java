package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends User {
    private final List<Course> enrolledCourses;
    private final List<Course> completedCourses; // Courses completed in previous semesters
    private double sgpa;
    private static final int MAX_CREDITS_PER_SEMESTER = 20;
    private int semester;

    // Constructor with name, email, password, and semester
    public Student(String name, String email, String password, int semester, double sgpa) {
        super(name, email, password);  // Call to the parent class User constructor
        this.enrolledCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.semester=semester;
        this.sgpa=sgpa;
    }

    // Getters and setters for semester
    public int getSemester() {
        return semester;  // Assuming User class has getSemester() method
    }

    public void setSemester(int semester) {
        this.semester=semester;  // Assuming User class has setSemester() method
    }

    // Method to calculate SGPA
    public double calculateSGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Course course : enrolledCourses) {
            totalGradePoints += course.getGrade() * course.getCredits();
            totalCredits += course.getCredits();
        }

        // Avoid division by zero if no courses are enrolled
        return totalCredits == 0 ? 0.0 : totalGradePoints / totalCredits;
    }

    // Method to check if a student has completed the prerequisites for a course
    private boolean prerequisitesMet(Course course) {
        for (String prereqCode : course.getPrerequisites()) {
            boolean completed = false;
            for (Course completedCourse : completedCourses) {
                if (completedCourse.getCode().equals(prereqCode)) {
                    completed = true;
                    break;
                }
            }
            if (!completed) {
                System.out.println("Prerequisite " + prereqCode + " not met for course " + course.getName());
                return false;
            }
        }
        return true;
    }

    // Method to view available courses according to semester
    public void viewAvailableCourses(List<Course> allCourses) {
        System.out.println("Courses available for semester " + getSemester() + ":");
        boolean foundCourse = false;
        for (Course course : allCourses) {
            if (course.getSemester() == getSemester()) {
                System.out.println("- " + course.getName() + " (" + course.getCode() + ") - Credits: " + course.getCredits());
                foundCourse = true;
            }
        }
        if (!foundCourse) {
            System.out.println("No courses available for your semester.");
        }
    }

    // Method to register for a course
    public void registerCourse(Course course) {
        if (course.getSemester() != getSemester()) {
            System.out.println("You can only register for courses in your current semester.");
            return;
        }

        if (!prerequisitesMet(course)) {
            System.out.println("You cannot register for " + course.getName() + " because prerequisites are not met.");
            return;
        }

        int totalCredits = enrolledCourses.stream().mapToInt(Course::getCredits).sum();
        if (totalCredits + course.getCredits() > MAX_CREDITS_PER_SEMESTER) {
            System.out.println("You cannot register for " + course.getName() + " as it exceeds the credit limit of " + MAX_CREDITS_PER_SEMESTER);
            return;
        }

        enrolledCourses.add(course);
        Course.enrollStudent(this);

        System.out.println("Successfully registered for " + course.getName() + " (" + course.getCode() + ")");
    }

    @Override
    public void viewOptions() {
        System.out.println("1. View Available Courses");
        System.out.println("2. Register for Courses");
        System.out.println("3. View Schedule");
        System.out.println("4. Track Progress");
        System.out.println("5. Drop Courses");
        System.out.println("6. Submit/View Complaints");
        System.out.println("7. Logout");
    }

    public void chooseOption(int option, List<Course> allCourses, Scanner sc) {
        switch (option) {
            case 1:
                viewAvailableCourses(allCourses);
                break;
            case 2:
                System.out.println("Enter the course code you want to register for: ");
                String courseCode = sc.nextLine();
                Course courseToRegister = findCourseByCode(allCourses, courseCode);
                if (courseToRegister != null) {
                    registerCourse(courseToRegister);
                } else {
                    System.out.println("Course with code " + courseCode + " not found.");
                }
                break;
            case 3:
                viewSchedule();
                break;
            case 4:
                //System.out.println("Your current SGPA is: " + calculateSGPA());
                //System.out.println("Your overall CGPA is: " + calculateCGPA());
                System.out.println("Your current SGPA is: " + sgpa);
                break;

            case 5:
                dropCourse(sc);
                break;
            case 6:
                System.out.println("1. Submit Complaint");
                System.out.println("2. View Complaints");
                int complaintChoice = sc.nextInt();
                sc.nextLine();  // Consume newline
                if (complaintChoice == 1) {
                    submitComplaint(sc);
                } else if (complaintChoice == 2) {
                    viewComplaints();
                } else {
                    System.out.println("Invalid option.");
                }
                break;
            case 7:
                System.out.println("Logging out...");
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Method to find a course by its code
    private Course findCourseByCode(List<Course> allCourses, String code) {
        return allCourses.stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    // Method to view the current schedule
    public void viewSchedule() {
        System.out.println("Your current schedule:");
        if (enrolledCourses.isEmpty()) {
            System.out.println("You are not enrolled in any courses.");
        } else {
            for (Course course : enrolledCourses) {
                System.out.println(course.getName() + " (" + course.getCode() + ") - Credits: " + course.getCredits());
                System.out.println("Class Timings: " + course.getClassTimings() + ", Location: " + course.getLocation() + ", Professor: " + course.getProfessor());
            }
        }
    }

    public double calculateCGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Course course : completedCourses) {
            totalGradePoints += course.getGrade() * course.getCredits();
            totalCredits += course.getCredits();
        }

        for (Course course : enrolledCourses) {
            totalGradePoints += course.getGrade() * course.getCredits();
            totalCredits += course.getCredits();
        }

        return totalCredits == 0 ? 0.0 : totalGradePoints / totalCredits;
    }

    // Method to drop a course
    public void dropCourse(Scanner sc) {
        System.out.println("Enter the course code of the course you want to drop: ");
        String courseCode = sc.nextLine();

        if (isDropAllowed()) {
            Course courseToDrop = findCourseByCode(enrolledCourses, courseCode);
            if (courseToDrop != null) {
                enrolledCourses.remove(courseToDrop);
                System.out.println("Successfully dropped " + courseToDrop.getName());
            } else {
                System.out.println("Course with code " + courseCode + " not found in your enrolled courses.");
            }
        } else {
            System.out.println("The drop deadline has passed.");
        }
    }

    private List<Complaint> complaints = new ArrayList<>();

    public void submitComplaint(Scanner sc) {
        System.out.println("Enter your complaint description: ");
        String description = sc.nextLine();
        complaints.add(new Complaint(description));
        System.out.println("Complaint submitted successfully.");
    }

    public void viewComplaints() {
        System.out.println("Your complaints:");
        for (Complaint complaint : complaints) {
            System.out.println("Complaint: " + complaint.getDescription() + " - Status: " + complaint.getStatus());
        }
    }

    private boolean isDropAllowed() {
        // Implement deadline logic here (e.g., check against a specific date or week number)
        return true;  // You can make this more dynamic
    }


}
