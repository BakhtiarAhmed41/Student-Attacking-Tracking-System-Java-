import java.util.*; 
 
class User { 
    private String studentName; 
    private int rollNumber; 
    private int totalClassesHeld; 
    private int totalClassesAttended; 
 
    public User(String studentName, int rollNumber, int totalClassesHeld, int 
totalClassesAttended) { 
        this.studentName = studentName; 
        this.rollNumber = rollNumber; 
        this.totalClassesHeld = totalClassesHeld; 
        this.totalClassesAttended = totalClassesAttended; 
    } 
 
    public void updateAttendance(int totalClassesHeld, int totalClassesAttended) { 
        this.totalClassesHeld = totalClassesHeld; 
        this.totalClassesAttended = totalClassesAttended; 
    } 
 
    public String getStudentName() { 
        return studentName; 
    } 
 
    public int getRollNumber() { 
        return rollNumber; 
    } 
 
    public int getTotalClassesHeld() { 
        return totalClassesHeld; 
    } 
 
    public int getTotalClassesAttended() { 
        return totalClassesAttended; 
    } 
 
    public double getAttendancePercentage() { 
         double percentage = ((double) totalClassesAttended / totalClassesHeld * 
100); 
        return Math.round(percentage * 100.0) / 100.0; 
    } 
} 
 
class StudentAttendanceSystem { 
    private Map<Integer, User> attendanceRecords; // Map<RollNumber, Student> 
 
    public StudentAttendanceSystem() { 
        attendanceRecords = new HashMap<>(); 
    } 
 
public void addOrUpdateStudentRecord(String studentName, int rollNumber, int totalClassesHeld, int totalClassesAttended) { 
    if (totalClassesAttended > totalClassesHeld) {
        System.out.println("Error: Attended classes cannot be greater than total classes held. Please enter again.");
        return;
    }

    if (attendanceRecords.containsKey(rollNumber)) { 
        User existingStudent = attendanceRecords.get(rollNumber); 
        if (!existingStudent.getStudentName().equals(studentName)) { 
            System.out.println("Error: A record with the same roll number but different name already exists."); 
            return; 
        }
        existingStudent.updateAttendance(totalClassesHeld, totalClassesAttended); 
        System.out.println("Record updated successfully!");
    } else { 
        User newStudent = new User(studentName, rollNumber, totalClassesHeld, totalClassesAttended); 
        attendanceRecords.put(rollNumber, newStudent);
        System.out.println("Record added successfully!");
    } 
}

    public void displayAllAttendance() { 
        if (attendanceRecords.isEmpty()) { 
            System.out.println("No records found."); 
            return; 
        } 
 
        System.out.println("All Student Records:"); 
        for (Map.Entry<Integer, User> entry : attendanceRecords.entrySet()) { 
            User student = entry.getValue(); 
            System.out.println("Roll Number: " + student.getRollNumber()); 
            System.out.println("\nStudent Name: " + student.getStudentName()); 
            System.out.println("\nAttendance Percentage: " + 
student.getAttendancePercentage() + "%"); 
            System.out.println("\nClasses Attended: " + 
student.getTotalClassesAttended()); 
            System.out.println("\nClasses Held: " + 
student.getTotalClassesHeld()); 
            System.out.println("\n--------------------------"); 
        } 
    } 
 
    public void displayAttendance(int rollNumber) { 
        if (!attendanceRecords.containsKey(rollNumber)) { 
            System.out.println("Student not found."); 
            return; 
        } 
 
        User student = attendanceRecords.get(rollNumber); 
        System.out.println("Attendance for Student " + student.getStudentName() + 
":"); 
        System.out.println("Attendance Percentage: " + 
student.getAttendancePercentage() + "%"); 
        System.out.println("Classes Attended: " + 
student.getTotalClassesAttended()); 
        System.out.println("Classes Held: " + student.getTotalClassesHeld()); 
    } 
 
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
                String studentName = scanner.nextLine().toLowerCase(); 
 
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
                        scanner.nextLine(); 
                        if (totalClassesAttended > totalClassesHeld) { 
                            System.out.println("Error: Attended classes cannot be greater than total classes held. Please enter again."); 
                            continue; 
                        } 
                        break; 
                    } catch (InputMismatchException e) { 
                        System.out.println("Invalid input. Please enter integers for roll number and total classes."); 
                        scanner.nextLine(); 
                    } 
                } 
 
                attendanceSystem.addOrUpdateStudentRecord(studentName, rollNumber, 
totalClassesHeld, totalClassesAttended); 
            } else if (input. equals("2")) { 
                attendanceSystem.displayAllAttendance(); 
            } else if (input.equals("3")) { 
                System.out.print("Enter roll number to view attendance: "); 
                int rollNumber = 0; 
                try { 
                    rollNumber = scanner.nextInt(); 
                    scanner.nextLine(); 
                } catch (InputMismatchException e) { 
                    System.out.println("Invalid input. Please enter an integer for roll number."); 
                    scanner.nextLine();  
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