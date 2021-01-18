package item;

import item.Item;
import java.sql.*;
import java.util.Scanner;

public class ItemTest 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in); 
        
        //System.out.println("Entering main");
        ItemTest.getConnection();
        //System.out.println("Exiting main");
        
        System.out.println();
        System.out.println("_____________________________");
        System.out.println("Item Program Started!");
        System.out.println("_____________________________");
        System.out.println();
        
        System.out.print("Would you like to add an item? ");
        String value = input.nextLine();
        if(value.equals("yes") == true || value.equals("Yes") == true || value.equals("YES") == true || value.equals("Y") == true || value.equals("y") == true)
        {     
            String v = "";
            System.out.print("Please enter your item name: ");
            String userItemName = input.nextLine();
            do
            { 
                System.out.print("Please enter your item's price: ");
                v = input.nextLine();
                if(v.matches("[0-9]+"))
                    break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
            }while(true);
            int userPrice = Integer.parseInt(v);
            
            System.out.print("Please enter your item's description: ");
            String userDes = input.nextLine();
            
            //key will be user's primary key
            Item item = new Item(0, userItemName, userPrice, userDes);
            int test = AddItem(item);
            if(test == 0)
                System.out.println("Unsuccessfully Added!");
            else
                System.out.println("Sucessfully Added!");
        }
        
        System.out.println();
        System.out.print("Would you like to delete an item? ");
        value = input.nextLine();
        if(value.equals("yes") == true || value.equals("Yes") == true || value.equals("YES") == true || value.equals("Y") == true || value.equals("y") == true)
        {
            String value2;
            do
            { 
                System.out.print("Please enter Item id to delete: ");
                    value2 = input.nextLine();
                    if(value2.matches("[0-9]+"))
                        break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
            }while(true);
            int val = Integer.parseInt(value2);
            int test = DeleteItem(val);
            
            if(test == 0)
                System.out.println("No deletion!");
            else
                System.out.println("Sucessfully deleted!");
        }
        
        System.out.println();
        System.out.print("Would you like to edit an item? ");
        value = input.nextLine();
        if(value.equals("yes") == true || value.equals("Yes") == true || value.equals("YES") == true || value.equals("Y") == true || value.equals("y") == true)
        {
            String val;
            do
            { 
                System.out.print("Please enter Item id to edit: ");
                val = input.nextLine();
                if(val.matches("[0-9]+"))
                        break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
            }while(true);
            int value3 = Integer.parseInt(val);     
            int test = EditItem(value3);
            
           if(test == 0)
                System.out.println("Nothing edited!");
            else
                System.out.println("Sucessfully edited!!");
        } 
        
        System.out.println();
        System.out.println("_____________________________");
        System.out.println("Item Program ended!");
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
           // System.out.println("END of getConnection try-block; CONNECTION SUCCESSFUL");
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
   
    public static int AddItem(Item ID)
    {
        int status = 0;
        
        try
        {
                Connection con = ItemTest.getConnection();

                PreparedStatement ps = con.prepareStatement("insert into item(ItemName, Price, Description) values (?,?,?)");
                ps.setString(1, ID.getItemName());
                ps.setInt(2,ID.getPrice());
                ps.setString(3,ID.getDescription());
    
                status = ps.executeUpdate();

                con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return status; 
    }
    
   
    public static int EditItem(int ID)
    {
        int status = 0;
        
        Scanner input = new Scanner(System.in);
 
        try
        {
                Connection con = ItemTest.getConnection();
                
                PreparedStatement ps = con.prepareStatement("update item set ItemName=?, Price=?, Description=? where Itemid=?");
                System.out.println();
                
                System.out.print("Please enter new item name: ");
                String nam = input.nextLine();
                ps.setString(1,nam);
                
                
                String val;
                do
                { 
                    System.out.print("Please enter new item price: ");
                    val = input.nextLine();
                    if(val.matches("[0-9]+"))
                        break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
                }while(true);
                int pri = Integer.parseInt(val);
                ps.setInt(2,pri);
                
                System.out.print("Please enter new item description: ");
                String des = input.nextLine();
                ps.setString(3,des);
                    
                ps.setInt(4,ID);

                status = ps.executeUpdate();

                con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        } 

        return status; 
    }
    
    public static int DeleteItem(int ID)
    {
        int status = 0;
    
	try
        {
		Connection con = ItemTest.getConnection();

		PreparedStatement ps = con.prepareStatement("delete from item where Itemid=?");
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
