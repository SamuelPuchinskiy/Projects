/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;
import profile.ProfileUser;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author bilalq
 */
public class ProfileTest 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Entering main");
        ProfileTest.getConnection();
        System.out.println("Exiting main");
        
        //ProfileUser user1 = new ProfileUser(1, "Bob", "Smith", 30, "bobsmith@gmail.com", "bob123", "smithpassword", "2248549");
        
        System.out.println();
        
        System.out.print("Would you like to make an account? (1 for yes or 2 for no ): ");
        int x = input.nextInt();
        System.out.println();
         
        if( x == 1)
        {
            System.out.print("What is your first name? ");
            String firstName = input.next();
             
            System.out.print("What is your last name? ");
            String lastName = input.next();
             
            System.out.print("How old are you? ");
            int age = input.nextInt();
             
            System.out.print("What is your email? ");
            String email = input.next();
             
            System.out.print("What do want your user name to be? ");
            String userName = input.next();
             
            System.out.print("What do you want your password to be? ");
            String passWord = input.next();
             
            System.out.print("What is your cell phone number? ");
            String cellPhone = input.next();
             
            ProfileUser user1 = new ProfileUser(1, firstName, lastName, age, email, userName, passWord, cellPhone);
             
            int test1 = AddProfile(user1);
             
            System.out.println();
             
            System.out.println("New Account has been made");
             
            System.out.println();
             
         }
        else
        {
            System.out.println("You entered 2");
            System.out.println("Please create an account to continue.");
            System.out.println("Goodbye");
        }
        
    }
    
    public static Connection getConnection()
    {
        Connection con = null;
        
        try
        {
            System.out.println("IN getConnection");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/project?serverTimezone=UTC";
            String user = "root";
            String pw = "OmarOsman01";
            
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("END of getConnection try-block; CONNECTION SUCCESSFUL");
        }
        catch(ClassNotFoundException cnf)
        {
            System.out.println("Class not found " + cnf);
            System.exit(0);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception " + e);
            System.exit(0);
        }
        System.out.println("EXIT getConnection");
        return(con);
    }
    
    public static int AddProfile(ProfileUser ID)
    {
        int status = 0;
        
        try
        {
                Connection con = ProfileTest.getConnection();

                PreparedStatement ps=con.prepareStatement("insert into user(firstName, lastName, age, email, userName, passWord, cellPhone) values (?,?,?,?,?,?,?)");
                
                ps.setString(1, ID.getFirstName());
                ps.setString(2,ID.getLastName());
                ps.setInt(3,ID.getAge());
                ps.setString(4, ID.getEmail());
                ps.setString(5,ID.getUserName());
                ps.setString(6,ID.getPassword());
                ps.setString(7,ID.getCell());

                status=ps.executeUpdate();

                con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return status;
    }
}
