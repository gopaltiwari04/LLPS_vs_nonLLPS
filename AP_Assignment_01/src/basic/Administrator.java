package basic;

import java.util.Scanner;

public class Administrator extends User {

    public Administrator(String name, String email, String password) {
        super(name, email, password);
    }

    public void chooseOption() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdministrator Options:");
            System.out.println("1. Manage Course Catalog");
            System.out.println("2. Manage Student Records");
            System.out.println("3. Assign Professors to Courses");
            System.out.println("4. Handle Complaints");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    manageCourseCatalog(scanner);
                    break;
                case 2:
                    manageStudentRecords(scanner);
                    break;
                case 3:
                    assignProfessorsToCourses(scanner);
                    break;
                case 4:
                    handleComplaints(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return; // Exit the method
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // 1. Manage Course Catalog
    private void manageCourseCatalog(Scanner scanner) {
        System.out.println("\n--- Manage Course Catalog ---");
        System.out.println("1. View Courses");
        System.out.println("2. Add Course");
        System.out.println("3. Delete Course");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (choice) {
            case 1:
                viewCourses();
                break;
            case 2:
                System.out.print("Enter course code: ");
                String courseCode = scanner.nextLine();
                System.out.print("Enter course title: ");
                String courseTitle = scanner.nextLine();
                System.out.print("Enter professor name: ");
                String professor = scanner.nextLine();
                System.out.print("Enter course credits: ");
                int credits = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                System.out.print("Enter course semester: ");
                int semester = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                Course newCourse = new Course(courseCode, courseTitle, professor, credits, null, semester, null, null, null);
                addCourse(newCourse);
                break;
            case 3:
                System.out.print("Enter course code to delete: ");
                String deleteCourseCode = scanner.nextLine();
                deleteCourse(deleteCourseCode);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    // 2. Manage Student Records
    private void manageStudentRecords(Scanner scanner) {
        System.out.println("\n--- Manage Student Records ---");
        System.out.println("1. View Student Records");
        System.out.println("2. Update Student Record");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (choice) {
            case 1:
                viewStudentRecords();
                break;
            case 2:
                System.out.print("Enter student email to update: ");
                String studentEmail = scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                System.out.print("Enter new semester: ");
                int newSemester = scanner.nextInt();
                scanner.nextLine(); // Clear newline

                // Create a new student object with updated details
                Student updatedStudent = new Student(newName, studentEmail, newPassword, newSemester);
                updateStudentRecord(studentEmail, updatedStudent);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }


    // 3. Assign Professors to Courses
    private void assignProfessorsToCourses(Scanner scanner) {
        System.out.println("\n--- Assign Professors to Courses ---");
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter professor name: ");
        String professorName = scanner.nextLine();
        assignProfessorToCourse(courseCode, professorName);
    }

    // 4. Handle Complaints
    private void handleComplaints(Scanner scanner) {
        System.out.println("\n--- Handle Complaints ---");
        System.out.println("1. View Complaints");
        System.out.println("2. Update Complaint Status");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (choice) {
            case 1:
                viewComplaints();
                break;
            case 2:
                System.out.print("Enter complaint description: ");
                String complaintText = scanner.nextLine();
                System.out.print("Enter new status (Pending/Resolved): ");
                String status = scanner.nextLine();
                updateComplaintStatus(complaintText, status);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    // Sample methods for course, student, complaint management
    private void viewCourses() {
        // Implementation for viewing all courses
    }

    private void addCourse(Course course) {
        // Implementation for adding a course
    }

    private void deleteCourse(String courseCode) {
        // Implementation for deleting a course by code
    }

    private void viewStudentRecords() {
        // Implementation for viewing student records
    }

    private void updateStudentRecord(String email, Student updatedStudent) {
        // Implementation for updating student record by email
    }

    private void assignProfessorToCourse(String courseCode, String professorName) {
        // Implementation for assigning a professor to a course
    }

    private void viewComplaints() {
        // Implementation for viewing all complaints
    }

    private void updateComplaintStatus(String complaintText, String status) {
        // Implementation for updating complaint status
    }
}
