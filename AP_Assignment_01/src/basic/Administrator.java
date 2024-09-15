/*package basic;

import java.util.List;
import java.util.Scanner;

public class Administrator extends User {

    public Administrator(String name, String email, String password) {
        super(name, email, password);
    }

    // Manage Course Catalog
    public void manageCourseCatalog(List<Course> allCourses, Scanner sc) {
        System.out.println("1. View all courses");
        System.out.println("2. Add a new course");
        System.out.println("3. Delete a course");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("All courses:");
                for (Course course : allCourses) {
                    System.out.println(course);
                }
                break;
            case 2:
                System.out.println("Enter course code: ");
                String code = sc.nextLine();
                System.out.println("Enter course name: ");
                String name = sc.nextLine();
                System.out.println("Enter professor: ");
                String professor = sc.nextLine();
                System.out.println("Enter credits: ");
                int credits = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.println("Enter timing: ");
                String timing = sc.nextLine();
                System.out.println("Enter location: ");
                String location = sc.nextLine();

                Course newCourse = new Course(code, name, professor, credits, new ArrayList<>(), 0, timing, location);
                allCourses.add(newCourse);
                System.out.println("Course added successfully.");
                break;
            case 3:
                System.out.println("Enter course code to delete: ");
                String delCode = sc.nextLine();
                Course courseToDelete = null;
                for (Course course : allCourses) {
                    if (course.getCode().equalsIgnoreCase(delCode)) {
                        courseToDelete = course;
                        break;
                    }
                }
                if (courseToDelete != null) {
                    allCourses.remove(courseToDelete);
                    System.out.println("Course deleted successfully.");
                } else {
                    System.out.println("Course not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Manage Student Records
    public void manageStudentRecords(List<Student> students, Scanner sc) {
        System.out.println("1. View all students");
        System.out.println("2. Update student records");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                for (Student student : students) {
                    System.out.println(student.getName() + " - " + student.getEmail());
                }
                break;
            case 2:
                System.out.println("Enter student email to update: ");
                String email = sc.nextLine();

                for (Student student : students) {
                    if (student.getEmail().equalsIgnoreCase(email)) {
                        System.out.println("Enter new academic standing: ");
                        int newStanding = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        student.setAcademicStanding(newStanding);
                        System.out.println("Record updated for student: " + student.getName());
                        break;
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Assign Professors to Courses
    public void assignProfessorsToCourses(List<Course> allCourses, Scanner sc) {
        System.out.println("Enter course code: ");
        String courseCode = sc.nextLine();

        System.out.println("Enter professor name to assign: ");
        String professorName = sc.nextLine();

        for (Course course : allCourses) {
            if (course.getCode().equalsIgnoreCase(courseCode)) {
                course.setProfessor(professorName);
                System.out.println("Professor " + professorName + " assigned to course " + courseCode);
                return;
            }
        }
        System.out.println("Course not found.");
    }

    // Handle complaints
    public void handleComplaints(List<Complaint> complaints, Scanner sc) {
        for (Complaint complaint : complaints) {
            System.out.println("Complaint: " + complaint.getDetails());
            System.out.println("Status: " + complaint.getStatus());
            System.out.println("Do you want to update this complaint to 'Resolved'? (yes/no)");
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                complaint.setStatus("Resolved");
                System.out.println("Complaint marked as Resolved.");
            }
        }
    }

    @Override
    public void viewOptions() {
        System.out.println("1. Manage Course Catalog");
        System.out.println("2. Manage Student Records");
        System.out.println("3. Assign Professors to Courses");
        System.out.println("4. Handle Complaints");
    }
}
*/


package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrator extends User {
    private List<Complaint> complaints;

    public Administrator(String name, String email, String password) {
        super(name, email, password);
        this.complaints = new ArrayList<>();
    }

    // View all complaints
    public void viewComplaints() {
        System.out.println("All complaints:");
        for (Complaint complaint : complaints) {
            System.out.println("Complaint: " + complaint.getDescription() + " - Status: " + complaint.getStatus());
        }
    }

    // Manage users (e.g., add, remove users)
    public void manageUsers(List<User> allUsers, Scanner sc) {
        System.out.println("Manage Users");
        System.out.println("1. View Users");
        System.out.println("2. Remove User");
        int choice = sc.nextInt();
        sc.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                viewUsers(allUsers);
                break;
            case 2:
                removeUser(allUsers, sc);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void viewUsers(List<User> allUsers) {
        System.out.println("List of Users:");
        for (User user : allUsers) {
            System.out.println(user);
        }
    }

    private void removeUser(List<User> allUsers, Scanner sc) {
        System.out.println("Enter the email of the user to remove: ");
        String email = sc.nextLine();
        User userToRemove = allUsers.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);

        if (userToRemove != null) {
            allUsers.remove(userToRemove);
            System.out.println("User with email " + email + " removed.");
        } else {
            System.out.println("User not found.");
        }
    }

    @Override
    public void viewOptions() {
        System.out.println("1. View Complaints");
        System.out.println("2. Manage Users");
    }

    // Add a complaint to the list (could be from a student or professor)
    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }
}
