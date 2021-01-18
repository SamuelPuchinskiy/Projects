// Get the while loop in login() to work as it should. verifycreds is not checking properly
package loginuser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginUser 
{
   // Class static variables
   public static Statement stmt;
   public static Connection conn;
   public static ResultSet rs;
   public static int count = 0; 
   public static Scanner input = new Scanner( System.in );
   
   public static void main( String[] args ) throws Exception
   {
      // Initialize the connection
      Connection conn = null;
      try
      {
         // Establish a connection to database. Update passcode and root to your own database.
         conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","OreoCakes*22*");
         if(conn!=null)
         {
             System.out.println("Hello and welcome to CafeGo!");
         }
         // Use the connection object to initialize a statement object
         stmt = conn.createStatement();
         menu();
      } // End try block
      
      
      catch( SQLException sqle )
      {
         // Handle any errors
         System.out.println( "SQL Exception: " + sqle.getMessage() );
         System.out.println( "SQL State: " + sqle.getSQLState() );
         System.out.println( "Vendor Error: " + sqle.getErrorCode() );
      } // End catch block
   } // End main()

   public static String addQuotes(String value)
   {
      String result = "'" +value+ "'";
      return result; 
   }
   
 //Begin post connection--------------------------------------
   //creates first time users/passwords
   public static void menu() throws Exception
    {
        System.out.println("What would you like to do?");
        System.out.println("Please select an option: (Enter a number from 1-3)");
        System.out.println();
        
        String s;
        int select;
        
        s = "1.Login\n"+
            "2.Create New Login\n"+
            "3.Exit";
       
       System.out.println(s);
       select = input.nextInt();
        
       if(select == 1)
       {
        login();
       }
       
       else if(select == 2)
       {
        newLogin();
       }
       
       else if(select == 3)
       {
        System.out.println("Logging off....");
        }
    }

    public static void newLogin() throws Exception
    {
        String user, pass;        
        System.out.print("Username: ");
        user = input.next();
        user = addQuotes(user);
            
        System.out.print("Password: ");
        pass = input.next();
        pass = addQuotes(pass);
        String sql = ("INSERT INTO log(username,password)" + 
                              "VALUES ("+user+","+pass+")");
    
        stmt.executeUpdate(sql);
        
        System.out.println("User successfully added.");
        option(user, pass);
    }

    public static void login() throws Exception
    {
        String user, pass;
        System.out.print("Enter Username: ");
        user = input.next();
        user = addQuotes(user);
        System.out.print("Enter Password: ");
        pass = input.next();
        pass = addQuotes(pass);
        
        validateUser(user, pass); //checks for user in the database
    }
    
    public static void validateUser(String user, String pass) throws Exception
    {
        System.out.println();
        String sql = "SELECT username FROM login.log WHERE username LIKE "+user;
        String sql2 = "SELECT password FROM login.log WHERE password LIKE "+pass;

        rs = stmt.executeQuery(sql);
  
        if (rs.next() == false && count !=4) 
        {
            count++;
            if(count < 4)
            {
                System.out.println("Invalid username, please try again.");
                System.out.println();
                login();
            }
            else
            {
                System.out.println("Account Lockout. Please wait 30 min.");
            }
        } 
        
        else 
        { 
            do 
            { 
                String data = rs.getString("username"); 
                System.out.println();
            } 
            while (rs.next()); 
        }
        
        rs = stmt.executeQuery(sql2);
        
        if (rs.next() == false) 
        {
            count++;
            System.out.println(count);
            if(count < 4)
            {
                System.out.println("Invalid password, please try again.");
                System.out.println();
                login();
            }
            else
            {
                System.out.println("Account Lockout. Please wait 30 min.");
            }
        } 
        else if(count > 3)
        {
            System.out.println("Account Lockout. Please wait 30 min.");
        }
        
        else 
        { 
            do 
            { 
                String data = rs.getString("password"); 
                System.out.println();
                option(user, pass);
            } 
            while (rs.next()); 
        }
    }
    
    //After successful login, user can change username or password
    public static void option(String user, String pass) throws Exception
    { 
       String s; 
       int select;
       System.out.println("Welcome back "+user+"!");
       System.out.println("What would you like to do?");
       System.out.println("Please select an option: (Enter a number from 1-2)");
       
       s = "1.Change Username\n"+
           "2.Change Password\n"+
           "3.Exit";
       
       System.out.println(s);
       select = input.nextInt();
       
       if(select == 1)
       {
        System.out.println("You have choosen to change your username.");
        changeUser(user);
       }
       
       else if(select == 2)
       {
        System.out.println("You have choosen to change your password.");
        changePass(pass);
       }
       else if(select == 3)
       {
        System.out.println("Logging off....");
        System.out.println("Goodbye " +user+"!");
       }
    }
    
    //Username and Password change methods-----------------------------------
    
    public static void changeUser(String user) throws Exception
    {
        String newUser;
        System.out.print("Enter a new username: ");
        newUser = input.next();
        newUser = addQuotes(newUser);
        String sql = "UPDATE login.log SET ";
        String identity = "WHERE username=" +user;
        sql = sql + "username=" +newUser+" "+identity;
        stmt.executeUpdate(sql);
        System.out.println("Username has been changed to "+newUser);

    }
    
    public static void changePass(String pass) throws Exception
    {
        String newPass;
        System.out.print("Enter a new password: ");
        newPass = input.next();
        newPass = addQuotes(newPass);
        String sql = "UPDATE login.log SET ";
        String identity = "WHERE password=" +pass;
        sql = sql + "password=" +newPass+" "+identity;
        stmt.executeUpdate(sql);
        System.out.println("Password has been changed.");
    }
}