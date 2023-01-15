package EntityQuiz;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Test {

	static int marks = 0;
	static String Grade;
	static List<Quiz> l = new ArrayList<Quiz>();   // to get Question And Answer In Insertion Order


	public static void main(String[] args) {

		try {
			// load the driver class
			Class.forName("com.mysql.jdbc.Driver");

			// Establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "Anku7237");

			java.sql.Statement stmnt = con.createStatement();

			//To take input from user 
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter Student Id");
			String ans1 = sc1.next();
			System.out.println("Enter Student Name");
			String ans2 = sc1.next();

			//Inserting data into database
			PreparedStatement ps1 = con.prepareStatement("select * from Student ;");
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {    

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('Number of primitive data types in Java are?','8','6','10','4','A')");

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('What is the size of float and double in java?','34 & 68','64 & 32','32 & 64','8 & 32','C')");

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('Select the valid statement to declare and initialize an array.','int []a={}','int []a={1,2,3}','int []a=(1,2,3}','int [][]a={1,2,3}','B')");

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('Array in java are?.','Object References','None','Objects','Primitive Data Type','C')");

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('Identify the corrected definition of a package.','Package is a Collection of a Editing Tool','Package is a Collection of Classes','Package is a Collection Of a Classes and Interface','Package is a collection of a interfaces','c')");

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('Identify the keyword among the following that makes a variable belong to a class,rather than being defined for each instance of the class.','final','abstract','static','volatile','C')");

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('compareTo() returns.','true','int value','false','None','B')");

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('Where does the system stores parameters and local variables whenever a method is invoked?','Heap','Array','Stack Area','Class Area','C')");

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('What is the implicit return type of constructor?','Void','None','class object which it is define','no return type','D')");

				stmnt.execute(
						"insert into questions_paper(Question,A,B,C,D,Correct_ans) values('When is the finalize() method called?','Before object goes out of scope','before garbage collection','Before Variable goes out of scope','None','B')");

			}

			// For taking The Question in random manner
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT distinct Question,A,B,C,D,Correct_ans FROM questions_paper  ORDER BY RAND ( ) ;");

			while (rs.next()) {
				Quiz q = new Quiz();
				q.setQuestions(rs.getString("Question"));
				q.setA(rs.getString("A"));
				q.setB(rs.getString("B"));
				q.setC(rs.getString("C"));
				q.setD(rs.getString("D"));
				q.setCorrect_ans(rs.getString("Correct_ans"));
				l.add(q);
			}

			for (int i = 0; i < 10; i++) {
				System.out.println("Question : " + l.get(i).getQuestions());
				System.out.println("A : " + l.get(i).getA());
				System.out.println("B : " + l.get(i).getB());
				System.out.println("C : " + l.get(i).getC());
				System.out.println("D : " + l.get(i).getD());
				Scanner sc = new Scanner(System.in);
				String ans = sc.next();

				if (ans.equals(l.get(i).getCorrect_ans())) {

					System.out.println("Your ans is correct");
					marks++;
				} else {
					System.out.println("Your ans is incorrect");
				}
			}

			//To design gardes according to marks 
			if (marks < 5) {
				Grade = "Sorry you are Fail, please try again! ";
			} else if (marks == 5) {
				Grade = "Congratulation you are cleared the test with Grade C ";
			} else if (marks == 6 || marks == 7 || marks == 8) {
				Grade = "Congratulation you are cleared the test with Grade B ";
			} else if (marks == 9 || marks == 10) {
				Grade = "Congratulation you are cleared the test with Grade A ";
			}
			String sql1 = "Update Student set grade=" + "'" + Grade + "'" + ", marks=" + "'" + marks + "' where id="
					+ "'" + ans1 + "'";
			PreparedStatement ps12 = con.prepareStatement(sql1);
			ps12.executeUpdate(sql1);
			
			//Result of Quiz 
			
			System.out.print("Hello ");
			System.out.print((ans1) + " : ");
			System.out.print(ans2 + " ");
			System.out.print(Grade);
			System.out.println("Your total score is : " + marks);

			Statement st1 = con.createStatement();
			ResultSet rs2 = st1.executeQuery(" Select * from student ORDER BY marks DESC ");

			while (rs2.next()) {

				System.out.println("Student Id :" + rs2.getString(1));
				System.out.println("Student name :" + rs2.getString(2));
				System.out.println("Student marks :" + rs2.getString(3));
				System.out.println("Student grade :" + rs2.getString(4));
			}

			//for checking the result by Student_id   
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter Student id>");
			String Id = scan2.next();
			ResultSet rs3 = st1.executeQuery("Select * from student where id =" + Id);
			while (rs3.next()) {
				System.out.println("Student Id :" + rs3.getString(1));
				System.out.println("Student name :" + rs3.getString(2));
				System.out.println("Student marks :" + rs3.getString(3));
				System.out.println("Student grade :" + rs3.getString(4));

			}

			stmnt.close();
			con.close();
			sc1.close();
			scan2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
