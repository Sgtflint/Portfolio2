
package com.company;
import java.sql.*; //from jdbc
import java.util.Scanner;
import static java.sql.DriverManager.*;
public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Path of database
            String url = "jdbc:sqlite:C:\\Users\\Frede\\Documents\\SoftwareDev\\Portifolio2.db";
            conn = getConnection(url);
// We will look at the rest in class
            // Contains a statement for connection conn
            Statement stmt = conn.createStatement();
// A string containing the SQL syntax
            String sql;

            sql = "SELECT * FROM Subscribed";
            ResultSet rs = stmt.executeQuery(sql);
            rs = stmt.executeQuery(sql);



            String ptripsql = "SELECT D1.StudentID,D1.StudentName, " +
                    "D2.CourseName, D2.Grades" +
                    "  FROM Student as D1 " +
                    "INNER join Subscribed as D2 on D1.StudentID =D2.StudentID ";
            PreparedStatement pTripStmt = conn.prepareStatement(ptripsql);
            rs = pTripStmt.executeQuery();
            StudentSUBjoin(rs);

            System.out.println(" Choose following:" +
                    "\n 1: Show average grade from StudentID" +
                    " \n 2: Show Average Grade from Course " +
                    "\n 3: Show Individual Grade from StudentID");
            Scanner scanner = new Scanner(System.in);
            int ChooserScanner = scanner.nextInt();

            if (ChooserScanner == 1) {
                System.out.println("Which Student ID do you want the average grade for?");
                scanner = new Scanner(System.in);
                int StudentScanner = scanner.nextInt();
                sql = "SELECT avg(Grades) FROM Subscribed WHERE StudentID ='" + StudentScanner + "'";
                ResultSet as = stmt.executeQuery(sql);
                AverageStudentGrade(as);
            }

            if (ChooserScanner == 2) {
                System.out.println("Which course do you want the average grade for? \n " +
                        "1: Software Development 2019 \n " +
                        "2: Software Development 2020 \n " +
                        "3: Essential Computing 2019");
                scanner = new Scanner(System.in);
                int CourseScanner = scanner.nextInt();


                if(CourseScanner == 1){
                    sql = "SELECT avg(Grades) FROM Subscribed WHERE courseID LIKE '2019' AND CourseName LIKE 'SD' ";
                    ResultSet as = stmt.executeQuery(sql);
                    AverageCourseGrade(as);
                }
                if(CourseScanner == 2){
                    sql = "SELECT avg(Grades) FROM Subscribed WHERE courseID LIKE '2020' AND CourseName LIKE 'SD' ";
                    ResultSet as = stmt.executeQuery(sql);
                    AverageCourseGrade(as);
                }
                if(CourseScanner == 3){
                    sql = "SELECT avg(Grades) FROM Subscribed WHERE courseID LIKE '2019' AND CourseName LIKE 'ES1' ";
                    ResultSet as = stmt.executeQuery(sql);
                    AverageCourseGrade(as);
                }


            }

            if (ChooserScanner == 3) {
                System.out.println("From which StudentID do you want to have a grade shown?");
                 scanner = new Scanner(System.in);
                int HælloScanner = scanner.nextInt();
                sql = "SELECT Grades FROM Subscribed WHERE StudentID ='" + HælloScanner + "'";
                ResultSet as = stmt.executeQuery(sql);
                studentIdGrades(as);
                stmt.executeUpdate(sql);



                System.out.println(" \nIf there's a Grade that is 0 ~ null it can be updated");
                System.out.println("Do you wish to update the Grade? \n" +
                        "1: No\n" +
                        "2: Yes");

                    Scanner scanneru = new Scanner(System.in);
                    ChooserScanner = scanneru.nextInt();

                    if (ChooserScanner == 2) {

                        System.out.println("Type desired Grade update ");
                        scanner = new Scanner(System.in);
                        int InsertScanner = scanner.nextInt();

                        sql = "UPDATE Subscribed set Grades = " + InsertScanner + " where StudentID = " + HælloScanner + " AND Grades is null";
                        stmt.executeUpdate(sql);

                    }


                }


        } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
    static public void AverageStudentGrade(ResultSet res)
            throws SQLException {
        if (res == null)
            System.out.println("No Data Found");
        while (res != null & res.next()) {
            // String Course = res.getString("CourseName");
            float Grades = res.getFloat("avg(Grades)");

            System.out.println(Grades);
        }
    }
    static public void StudentSUBjoin(ResultSet res)
            throws SQLException {
        if (res == null)
            System.out.println("No records found");
        while (res != null & res.next()) {
            String StudentName = res.getString("Studentname");
            int Grades = res.getInt("Grades");
            String CourseName = res.getString("Coursename");
            int StudentID = res.getInt("StudentID");
            System.out.println("Student name: "
                    + StudentName +
                    ", Grade: "
                    +Grades+
                    ", Course: "
                    + CourseName +", StudentID: " + StudentID);
        }
    }
    static public void studentIdGrades(ResultSet res)
            throws SQLException {
        Connection conn = null;
        if (res == null)
            System.out.println("No Data Found");

        while (res != null & res.next()) {


            int Grades = res.getInt("Grades");
            //String CourseName = res.getString("CourseName");
            System.out.println(Grades + " ");

        }
    }
    static public void AverageCourseGrade(ResultSet res)
            throws SQLException {
        if (res == null)
            System.out.println("No Data Found");
        while (res != null & res.next()) {

            float Grades = res.getFloat("avg(Grades)");
            System.out.println(Grades);
        }
    }
}




