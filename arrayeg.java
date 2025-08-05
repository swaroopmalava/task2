import java.util.ArrayList;
import java.util.Scanner;
public class arrayeg {
    int sid;
    String name;
    int marks;

    arrayeg(int sid, String name, int marks) {
        this.sid = sid;
        this.name = name;
        this.marks = marks;
    }

    public void getDetails(Scanner sc) {
        System.out.print("Enter id: ");
        this.sid = sc.nextInt();
        System.out.print("Enter name: ");
        this.name = sc.next();
        System.out.print("Enter marks: ");
        this.marks = sc.nextInt();
    }

    public void displayDetails() {
        System.out.println("Id: " + sid + ", Name: " + name + ", Marks: " + marks);
    }

    public static int findStudentIndex(ArrayList<arrayeg> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).sid == id) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<arrayeg> students = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: // Add
                    arrayeg newStudent = new arrayeg(0, "", 0);
                    newStudent.getDetails(sc);
                    students.add(newStudent);
                    System.out.println("Student added successfully.");
                    break;
                case 2: // View
                    if (students.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (arrayeg s : students) {
                            s.displayDetails();
                        }
                    }
                    break;
                case 3: // Update
                    System.out.print("Enter student id to update: ");
                    int upId = sc.nextInt();
                    int upIdx = findStudentIndex(students, upId);
                    if (upIdx != -1) {
                        System.out.println("Enter new details:");
                        students.get(upIdx).getDetails(sc);
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4: // Delete
                    System.out.print("Enter student id to delete: ");
                    int delId = sc.nextInt();
                    int delIdx = findStudentIndex(students, delId);
                    if (delIdx != -1) {
                        students.remove(delIdx);
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
        sc.close();
    }
}
