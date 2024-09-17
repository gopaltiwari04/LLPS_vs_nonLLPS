package basic;

import java.util.List;
import java.util.Scanner;

public class Professor extends User {
    private List<Course> courses;

    public Professor(String name, String email, String password) {
        super(name, email, password);
    }

    // Manage courses: Professors can update course details (syllabus, timings, etc.)
    public void manageCourses(List<Course> allCourses, Scanner sc) {
        System.out.println("Courses you are assigned to:");
        for (Course course : allCourses) {
            if (course.getProfessor().equals(this.getName())) {
                System.out.println(course);
            }
        }

        System.out.println("Do you want to update a course's details? (yes/no)");
        String response = sc.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter course code to update: ");
            String courseCode = sc.nextLine();

            Course selectedCourse = findCourseByCode(allCourses, courseCode);
            if (selectedCourse != null && selectedCourse.getProfessor().equals(this.getName())) {
                System.out.println("Updating details for course: " + selectedCourse.getName());

                System.out.println("Enter new class timing: ");
                selectedCourse.setClassTimings(sc.nextLine());

                System.out.println("Enter new credits: ");
                selectedCourse.setCredits(sc.nextInt());
                sc.nextLine(); // Consume newline

                System.out.println("Course updated successfully!");
            } else {
                System.out.println("Invalid course code or you are not assigned to this course.");
            }
        }
    }

    // View enrolled students
    public void viewEnrolledStudents(List<Course> allCourses) {
        boolean coursesFound = false; // To track if the professor has any assigned courses

        for (Course course : allCourses) {
            if (course.getProfessor().equals(this.getName())) {
                coursesFound = true;
                System.out.println("\nEnrolled students for course: " + course.getName() + " (" + course.getCode() + ")");

                List<Student> students = course.getEnrolledStudents();

                if (students == null || students.isEmpty()) {
                    System.out.println("No students enrolled in this course.");
                } else {
                    for (Student student : students) {
                        System.out.println("Name: " + student.getName() + " | Email: " + student.getEmail());
                    }
                }
                System.out.println("-------------------------"); // Separator for clarity
            }
        }

        if (!coursesFound) {
            System.out.println("You are not assigned to any courses or no students are enrolled.");
        }
    }


    public void chooseOption(int option, List<Course> allCourses, Scanner sc) {
        boolean exit = false;

        while (!exit) {
            viewOptions();
            //System.out.println("Enter your choice (1 or 2), or 0 to exit:");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageCourses(allCourses, sc);
                    break;
                case 2:
                    viewEnrolledStudents(allCourses);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void viewOptions() {
        System.out.println("1. Manage Courses");
        System.out.println("2. View Enrolled Students");
    }

    // Helper method to find a course by its code
    private Course findCourseByCode(List<Course> allCourses, String code) {
        return allCourses.stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}