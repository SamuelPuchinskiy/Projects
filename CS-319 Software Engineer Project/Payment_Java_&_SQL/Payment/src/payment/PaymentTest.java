package payment;
import payment.PaymentCard;

import java.util.Scanner;

import java.sql.*;

public class PaymentTest
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in); 
        
        //System.out.println("Entering main");
        PaymentTest.getConnection();
        //System.out.println("Exiting main");
        
        System.out.println();
        System.out.println("_____________________________");
        System.out.println("Payment Program Started!");
        System.out.println("_____________________________");
        System.out.println();
        
        System.out.println();
        System.out.print("Would you like to add a card? ");
        String value = input.nextLine();
        if(value.equals("yes") == true || value.equals("Yes") == true || value.equals("YES") == true || value.equals("Y") == true || value.equals("y") == true)
        {     
            String v = "";
            System.out.print("Please enter your bank name: ");
            String userBankName = input.nextLine();
            do
            { 
                System.out.print("Please enter your card number: ");
                v = input.nextLine();
                if(v.matches("[0-9]+"))
                    break;
                System.out.println("Input entered is not numeric, please try agian.");
            }while(true);
            int userCardNum = Integer.parseInt(v);

            do
            { 
                System.out.print("Please enter your card CVC code: ");
                v = input.nextLine();
                if(v.matches("[0-9]+"))
                    break;
                System.out.println("Input entered is not numeric, please try agian.");
            }while(true);
            int userCVCCode = Integer.parseInt(v);
            
            do
            { 
                System.out.print("Please enter your card's experation date (in 0120 format for Januray 2020): ");
                v = input.nextLine();
                if(v.matches("[0-9]+"))
                    break;
                System.out.println("Input entered is not numeric, please try agian.");
            }while(true);
            int userCardEXPDate = Integer.parseInt(v);     
            //key will be user's primary key
            PaymentCard cardTest = new PaymentCard(0, userBankName, userCardNum, userCVCCode, userCardEXPDate);
            int test = AddPayment(cardTest);
            if(test == 0)
                System.out.println("Unsuccessfully Added!");
            else
                System.out.println("Sucessfully Added!");
        }
        
        System.out.println();
        System.out.print("Would you like to delete a card? ");
        value = input.nextLine();
        if(value.equals("yes") == true || value.equals("Yes") == true || value.equals("YES") == true || value.equals("Y") == true || value.equals("y") == true)
        {
            String value2;
            do
            { 
                System.out.print("Please enter Payment id to delete: ");
                value2 = input.nextLine();
                if(value2.matches("[0-9]+"))
                    break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
            }while(true);
            
            int val = Integer.parseInt(value2);
            int test = DeletePayment(val);
            
            if(test == 0)
                System.out.println("No deletion!");
            else
                System.out.println("Sucessfully deleted!");
        }
        
        System.out.println();
        System.out.print("Would you like to edit a card? ");
        value = input.nextLine();
        if(value.equals("yes") == true || value.equals("Yes") == true || value.equals("YES") == true || value.equals("Y") == true || value.equals("y") == true)
        {
            String value2;
            do
            { 
                System.out.print("Please enter Payment id to edit: ");
                value2 = input.nextLine();
                if(value2.matches("[0-9]+"))
                    break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
            }while(true);
            int val = Integer.parseInt(value2);
            int test = EditPayment(val);
            
           if(test == 0)
                System.out.println("Nothing edited!");
            else
                System.out.println("Sucessfully edited!!");
        }  
        
        System.out.println();
        System.out.println("_____________________________");
        System.out.println("Payment Program ended!");
        System.out.println("_____________________________");
        System.out.println();
    }
    
    
    public static Connection getConnection()
    {
        Connection con = null;
        
        try
        {
            //System.out.println("IN getConnection");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
            
            String user = "root";
            String pw = "1998";
            
            con = DriverManager.getConnection(url, user, pw);
            //System.out.println("END of getConnection try-block; CONNECTION SUCCESSFUL");
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
        //System.out.println("EXIT getConnection");
        return(con);
    }
    
    public static int AddPayment(PaymentCard ID)
    {
        int status = 0;
        
        try
        {
                Connection con = PaymentTest.getConnection();

                PreparedStatement ps = con.prepareStatement("insert into payment(BankName, CardNum, CVCCode, expirationDate) values (?,?,?,?)");
                ps.setString(1, ID.getBankName());
                ps.setInt(2,ID.getCardNum());
                ps.setInt(3,ID.getCVCCode());
                ps.setInt(4,ID.getexpirationDate());

                status = ps.executeUpdate();

                con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return status; 
    }
   
    public static int EditPayment(int ID)
    {
        int status = 0;
        
        Scanner input = new Scanner(System.in);
        
        try
        {
                Connection con = PaymentTest.getConnection();
                
                PreparedStatement ps = con.prepareStatement("update payment set BankName=?, CardNum=?, CVCCode=?, expirationDate=? where Paymentid=?");
                System.out.println();
                
                String v;
                
                System.out.print("Please enter new bank name: ");
                String b = input.nextLine();
                ps.setString(1,b);
                
                do
                { 
                    System.out.print("Please enter new bank number: ");
                    v = input.nextLine();
                    if(v.matches("[0-9]+"))
                        break;
                    System.out.println("Input entered is not numeric, please try agian.");
                }while(true);
                int num = Integer.parseInt(v);
                ps.setInt(2,num);
                
                
                do
                { 
                    System.out.print("Please enter new bank CVC: ");
                    v = input.nextLine();
                    if(v.matches("[0-9]+"))
                        break;
                     System.out.println("Input entered is not numeric, please try agian.");
                }while(true);
                int cvc = Integer.parseInt(v);
                ps.setInt(3,cvc);
                
  
                do
                { 
                    System.out.print("Please enter new expiration date in (0120 format): ");
                    v = input.nextLine();
                    if(v.matches("[0-9]+"))
                        break;
                     System.out.println("Input entered is not numeric, please try agian.");
                }while(true);
                int exp = Integer.parseInt(v);
                ps.setInt(4,exp);
                
                ps.setInt(5,ID);

                status = ps.executeUpdate();

                con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        } 

        return status; 
    }
      
    public static int DeletePayment(int ID)
    {
        int status = 0;
    
	try
        {
		Connection con = PaymentTest.getConnection();

		PreparedStatement ps = con.prepareStatement("delete from payment where Paymentid=?");
		ps.setInt(1, ID);
		status = ps.executeUpdate();
		 
		con.close();
	}
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
	return status;
    }   
}