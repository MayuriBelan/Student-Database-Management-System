package StudentDatabase;
import java.sql.*;
import java.util.*;

public class AddAndDelete
{
	
public static void main(String[] args) throws Exception
{
	//int i=0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
	Scanner sc=new Scanner(System.in);
	do {
		System.out.println("Welcome to Student Database Management System");
		System.out.println("1: Add \n2: Update \n3: Delete \n4: Retrieve");
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		if(ch==1)
		{
			CallableStatement cs1=con.prepareCall("{ call adding(?,?,?,?)}");
			System.out.println("Enter student roll number");
			int roll=sc.nextInt();
			System.out.println("Enter student first name");
			//String f=sc.next();
			String f_name=sc.next();
			System.out.println("Enter student last name");
			//String l=sc.next();
			String l_name=sc.next();
			System.out.println("Enter student standard");
			int std=sc.nextInt();
			//Set method
			cs1.setInt(1, roll);
			cs1.setString(2, f_name);
			cs1.setString(3, l_name);
			cs1.setInt(4, std);
			
			cs1.execute();
			cs1.close();
			System.out.println("Data inserted successfully");
		}
		
		if(ch==2)
		{
			System.out.println("Enter data which you want to delete	");
			System.out.println(" roll or FirstName	or LastName or standard");
			String str1=sc.next();	
			
			System.out.println("Enter the roll number of student for which you want to update data");
			int id=sc.nextInt();
			// System.out.println("Enter the firstname of student you want to update roll no."); 
			 //String string1=sc.next();
					 
			 System.out.println(str1);
			String str[]= {"roll","FirstName","LastName","standard"};
			
			if(str1.equals(str[0]))
					{
					
					System.out.println("Enter new roll");
				int new_roll=sc.nextInt();
				//int s1=Integer.parseInt(str1);						
				CallableStatement cs2_1=con.prepareCall(" { call updateroll(?,?)}");
				cs2_1.setInt(1, new_roll);
				cs2_1.setInt(2, id);			
				cs2_1.execute();
				cs2_1.close();
				System.out.println("New roll number updated sucessfully");
				
					}
			else if(str1.equals(str[3]))
					{
				System.out.println("Enter new standard");
				int new_std=sc.nextInt();
				CallableStatement cs2_4=con.prepareCall(" { call updatestd(?,?)}");
				cs2_4.setInt(1, new_std);
				cs2_4.setInt(2, id);
				cs2_4.execute();
				cs2_4.close();
				
				System.out.println("New Statndard for roll no."+id+" has been updated");
			         //    ].out.println("Enter new roll/firstName/LastName/Standard");
			//String new_name=sc.next();		
			//System.out.println(str2);
			
				
			}
			
		}
	}while(true);
}
}

