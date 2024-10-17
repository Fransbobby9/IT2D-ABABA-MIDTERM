package AbabaFrans2D;

import java.util.Scanner;


public class AbabaFrans2D{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            String response;
            do {
                System.out.println("1. ADD :");
                System.out.println("2. VIEW : ");
                System.out.println("3. UPDATE ");
                System.out.println("4. DELETE ");
                System.out.println("5. EXIT");
                
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                AbabaFrans2D instructor = new AbabaFrans2D();
                sc.nextLine();
                
                
                switch (choice) {
                    case 1:
                        instructor.addInstructor(sc);
                        break;
                    case 2:
                        instructor.viewInstructor();
                        break;
                    case 3:
                        instructor.viewInstructor();
                        instructor.updateInstructor(sc);
                        instructor.viewInstructor();
                        break;
                    case 4:
                        instructor.viewInstructor();
                        instructor.deleteInstructor(sc);
                        instructor.viewInstructor();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println("do you want to continue ? (yes/no) :");
                response = sc.next();
            } while (response.equalsIgnoreCase("yes"));
            System.out.println("Thank you, See you soonest!");
        }
    }

    public static void addInstructor(Scanner sc) {
        config conf = new config();
        
        System.out.print("Enter Instructor Name: ");
        String name = sc.next();
        System.out.print("Enter Email : ");
        String email = sc.next();
        System.out.print("Enter Department : ");
        String department = sc.next();
        System.out.print("Enter Phone Number : ");
        String pnumber = sc.next();
        System.out.print("Enter Hire Date : ");
        String hdate = sc.next();

        String sql = "INSERT INTO tbl_instructor (name, email, department, phone_number, hire_date) VALUES (?, ?, ?, ?, ?)";
        conf.addInstructor(sql, name,email,department, pnumber, hdate);
    }

    public static void viewInstructor() {
        config conf = new config();
        String sqlQuery = "SELECT * FROM tbl_instructor";
        String[] columnHeaders = {"Instructor ID", "Insurance Name", "email", "department","phone_number","hire_date"};
        String[] columnNames =   {"Instructor ID", "Insurance Name", "email", "department","phone_number","hire_date"};
        conf.viewInstructor(sqlQuery, columnHeaders, columnNames);
    }

    public static void updateInstructor(Scanner sc) {
        config conf = new config();

        System.out.print("Enter the ID of Instructor to edit: ");
        int id = sc.nextInt();
        sc.nextLine();

       System.out.print("Enter Instructor Name: ");
        String name = sc.next();
        System.out.print("Enter Email : ");
        String email = sc.next();
        System.out.print("Enter Department : ");
        String department = sc.next();
        System.out.print("Enter Phone Number : ");
        String pnumber = sc.next();
        System.out.print("Enter Hire Date : ");
        String hdate = sc.next();
        
        String sql = "UPDATE tbl_insurance SET name = ?, email = ?, department = ?, phone_number = ?, hire_date = ? WHERE i_id = ?";
        conf.updateInstructor(sql, name,email,department, pnumber, hdate, id);
        System.out.println("Instructor updated successfully.");
    }

    public static void deleteInstructor(Scanner sc) {
        config conf = new config();
        System.out.print("Enter the ID of Instructor to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM tbl_Instructor WHERE i_id = ?";
        conf.deleteInstructor(sql, id);
        System.out.println("Instructor deleted successfully.");
    }
}