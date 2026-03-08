package com.student;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection con = DatabaseConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    String insertQuery = "INSERT INTO students VALUES(?,?,?,?)";

                    PreparedStatement ps = con.prepareStatement(insertQuery);
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, age);
                    ps.setString(4, course);

                    ps.executeUpdate();

                    System.out.println("Student Added Successfully!");
                    break;


                case 2:
                    String selectQuery = "SELECT * FROM students";

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(selectQuery);

                    System.out.println("\nID | Name | Age | Course");

                    while(rs.next()) {
                        System.out.println(
                                rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("course")
                        );
                    }
                    break;


                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    String updateQuery = "UPDATE students SET course=? WHERE id=?";

                    PreparedStatement ps2 = con.prepareStatement(updateQuery);
                    ps2.setString(1, newCourse);
                    ps2.setInt(2, uid);

                    ps2.executeUpdate();

                    System.out.println("Student Updated Successfully!");
                    break;


                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int did = sc.nextInt();

                    String deleteQuery = "DELETE FROM students WHERE id=?";

                    PreparedStatement ps3 = con.prepareStatement(deleteQuery);
                    ps3.setInt(1, did);

                    ps3.executeUpdate();

                    System.out.println("Student Deleted Successfully!");
                    break;


                case 5:
                    System.out.println("Exiting program...");
                    con.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}