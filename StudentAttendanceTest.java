import java.util.*;

public class StudentAttendanceTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentAttendanceSystem attendanceSystem = new StudentAttendanceSystem();

        while (true) {
            System.out.println("\nChoose a test case:");
            System.out.println("1. Add a new student record");
            System.out.println("2. Update an existing student record ");
            System.out.println("3. Add a record with invalid attendance");
            System.out.println("4. Display all attendance records");
            System.out.println("5. Display an individual student record");
            System.out.println("6. Display non-existing student record");
            System.out.println("7. Add multiple student records");
            System.out.println("8. Attempt to update non-existing student record");
            System.out.println("9. Add a record with negative total classes held");
            System.out.println("10. Add a record with negative total classes attended");
            System.out.println("11. Add a record with total classes attended greater than total classes held");
            System.out.println("12. Exit the system");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    attendanceSystem.addOrUpdateStudentRecord("Fawad", 101, 10, 8);
                    break;
                case 2:
                    attendanceSystem.addOrUpdateStudentRecord("Fawad", 101, 12, 9);
                    break;
                case 3:
                    attendanceSystem.addOrUpdateStudentRecord("Anas", 102, 8, 10);
                    break;
                case 4:
                    attendanceSystem.displayAllAttendance();
                    break;
                case 5:
                    attendanceSystem.displayAttendance(101); // Fawad's roll number
                    break;
                case 6:
                    attendanceSystem.displayAttendance(103); // Non-existing roll number
                    break;
                case 7:
                    attendanceSystem.addOrUpdateStudentRecord("Saqlain", 103, 8, 8);
                    attendanceSystem.addOrUpdateStudentRecord("Maqsood", 104, 9, 6);
                    break;
                case 8:
                    attendanceSystem.addOrUpdateStudentRecord("Non-existing student", 111, 5, 3);
                    break;
                case 9:
                    attendanceSystem.addOrUpdateStudentRecord("Negative Classes", 113, -5, 3);
                    break;
                case 10:
                    attendanceSystem.addOrUpdateStudentRecord("Negative Attended", 114, 5, -3);
                    break;
                case 11:
                    attendanceSystem.addOrUpdateStudentRecord("Greater Attendance", 115, 10, 15);
                    break;
                case 12:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}


