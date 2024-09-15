/*package basic;

import java.util.List;
import java.util.Scanner;

public class Professor extends User {
    private List<Course> courses;

    public Professor(String name, String email, String password) {
        super(name, email, password);
    }

    // Manage courses
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

            Course selectedCourse = null;
            for (Course course : allCourses) {
                if (course.getCode().equalsIgnoreCase(courseCode) && course.getProfessor().equals(this.getName())) {
                    selectedCourse = course;
                    break;
                }
            }

            if (selectedCourse != null) {
                System.out.println("Updating details for course: " + selectedCourse.getName());
                System.out.println("Enter new syllabus: ");
                selectedCourse.setSyllabus(sc.nextLine());

                System.out.println("Enter new class timing: ");
                selectedCourse.setTiming(sc.nextLine());

                System.out.println("Enter new credits: ");
                selectedCourse.setCredits(sc.nextInt());
                sc.nextLine(); // Consume newline

                System.out.println("Course updated successfully!");
            } else {
                System.out.println("Invalid course code or you are not assigned to this course.");
            }
        }
    }

    private String getName() {
        return name;
    }

    // View enrolled students
    public void viewEnrolledStudents(List<Course> allCourses) {
        System.out.println("Courses you are assigned to:");
        for (Course course : allCourses) {
            if (course.getProfessor().equals(this.getName())) {
                System.out.println("Enrolled students for course: " + course.getName());
                for (Student student : course.getEnrolledStudents()) {
                    System.out.println(student.getName() + " - " + student.getEmail());
                }
            }
        }
    }

    @Override
    public void viewOptions() {
        System.out.println("1. Manage Courses");
        System.out.println("2. View Enrolled Students");
    }
}
*/
/*
package basic;

import java.util.List;
import java.util.Scanner;

public class Professor extends User {
    private List<Course> courses;

    public Professor(String name, String email, String password) {
        super(name, email, password);
    }

    // Manage courses
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

            Course selectedCourse = null;
            for (Course course : allCourses) {
                if (course.getCode().equalsIgnoreCase(courseCode) && course.getProfessor().equals(this.getName())) {
                    selectedCourse = course;
                    break;
                }
            }

            if (selectedCourse != null) {
                System.out.println("Updating details for course: " + selectedCourse.getName());
                System.out.println("Enter new syllabus: ");
                selectedCourse.setSyllabus(sc.nextLine());

                System.out.println("Enter new class timing: ");
                selectedCourse.setTiming(sc.nextLine());

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
        System.out.println("Courses you are assigned to:");
        for (Course course : allCourses) {
            if (course.getProfessor().equals(this.getName())) {
                System.out.println("Enrolled students for course: " + course.getName());
                for (Student student : course.getEnrolledStudents()) {
                    System.out.println(student.getName() + " - " + student.getEmail());
                }
            }
        }
    }

    @Override
    public void viewOptions() {
        System.out.println("1. Manage Courses");
        System.out.println("2. View Enrolled Students");
    }

    private String getName() {
        return super.getName();  // Access parent's getName()
    }
}
*/

package basic;

import java.util.List;
import java.util.Scanner;

public class Professor extends User {
    private List<Course> courses;

    public Professor(String name, String email, String password) {
        super(name, email, password);
    }

    // Manage courses
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
        System.out.println("Courses you are assigned to:");
        for (Course course : allCourses) {
            if (course.getProfessor().equals(this.getName())) {
                System.out.println("Enrolled students for course: " + course.getName());
                for (Student student : course.getEnrolledStudents()) {
                    System.out.println(student.getName() + " - " + student.getEmail());
                }
            }
        }
    }

    @Override
    public void viewOptions() {
        System.out.println("1. Manage Courses");
        System.out.println("2. View Enrolled Students");
    }

    // Method to find a course by its code
    private Course findCourseByCode(List<Course> allCourses, String code) {
        return allCourses.stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
