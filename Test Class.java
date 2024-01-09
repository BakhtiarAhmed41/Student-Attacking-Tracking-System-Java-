import java.util.Scanner;

public class TestStudentAttendanceSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentAttendanceSystem attendanceSystem = new StudentAttendanceSystem();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add or update a student record");
            System.out.println("2. View all student records");
            System.out.println("3. View an individual student record");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine().toLowerCase(); // Convert input to lowercase

            if (input.equals("1")) {
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine().toLowerCase(); // Convert input to lowercase

                int rollNumber = 0;
                int totalClassesHeld = 0;
                int totalClassesAttended = 0;

                while (true) {
                    try {
                        System.out.print("Enter roll number: ");
                        rollNumber = scanner.nextInt();
                        System.out.print("Enter total classes held: ");
                        totalClassesHeld = scanner.nextInt();
                        System.out.print("Enter total classes attended: ");
                        totalClassesAttended = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        if (totalClassesAttended > totalClassesHeld) {
                            System.out.println("Error: Attended classes cannot be greater than total classes held. Please enter again.");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter integers for roll number and total classes.");
                        scanner.nextLine(); // Clear the input buffer
                    }
                }

                attendanceSystem.addOrUpdateStudentRecord(studentName, rollNumber, totalClassesHeld, totalClassesAttended);
            } else if (input.equals("2")) {
                attendanceSystem.displayAllAttendance();
            } else if (input.equals("3")) {
                System.out.print("Enter roll number to view attendance: ");
                int rollNumber = 0;
                try {
                    rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer for roll number.");
                    scanner.nextLine(); // Clear the input buffer
                    continue;
                }
                attendanceSystem.displayAttendance(rollNumber);
            } else if (input.equals("4")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }

        scanner.close();
    }
}
