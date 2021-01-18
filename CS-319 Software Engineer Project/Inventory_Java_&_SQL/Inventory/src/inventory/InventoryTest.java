package inventory;

import inventory.Inventory;
import java.sql.*;
import java.util.Scanner;


public class InventoryTest 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); 
        
        //System.out.println("Entering main");
        InventoryTest.getConnection();
        //System.out.println("Exiting main");
        
        System.out.println();
        System.out.println("_____________________________");
        System.out.println("Item Program Started!");
        System.out.println("_____________________________");
        System.out.println();
        
        
        
        
        System.out.print("Would you like to add inventory? ");
        String value = input.nextLine();
        if(value.equals("yes") == true || value.equals("Yes") == true || value.equals("YES") == true || value.equals("Y") == true || value.equals("y") == true)
        {     
            String v = "";
            System.out.print("Please enter your item name: ");
            String userItem = input.nextLine();
            do
            { 
                System.out.print("Please enter item's inventory quantity: ");
                v = input.nextLine();
                if(v.matches("[0-9]+"))
                    break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
            }while(true);
            int userQuantity = Integer.parseInt(v);
            
            //key will be user's primary key
            Inventory invent = new Inventory(0, userItem, userQuantity);
            int test = AddInventory(invent);
            if(test == 0)
                System.out.println("Unsuccessfully Added!");
            else
                System.out.println("Sucessfully Added!");
        }
            
            
        System.out.println();
        System.out.print("Would you like to delete inventory? ");
        value = input.nextLine();
        if(value.equals("yes") == true || value.equals("Yes") == true || value.equals("YES") == true || value.equals("Y") == true || value.equals("y") == true)
        {
            String value2;
            do
            { 
                System.out.print("Please enter Inventory id to delete: ");
                    value2 = input.nextLine();
                    if(value2.matches("[0-9]+"))
                        break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
            }while(true);
            int val = Integer.parseInt(value2);
            int test = DeleteInventory(val);
            
            if(test == 0)
                System.out.println("No deletion!");
            else
                System.out.println("Sucessfully deleted!");
        }
        
        System.out.println();
        System.out.print("Would you like to edit inventory? ");
        value = input.nextLine();
        if(value.equals("yes") == true || value.equals("Yes") == true || value.equals("YES") == true || value.equals("Y") == true || value.equals("y") == true)
        {
            String val;
            do
            { 
                System.out.print("Please enter inventory id to edit: ");
                val = input.nextLine();
                if(val.matches("[0-9]+"))
                        break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
            }while(true);
            int value3 = Integer.parseInt(val);     
            int test = EditInventory(value3);
            
           if(test == 0)
                System.out.println("Nothing edited!");
            else
                System.out.println("Sucessfully edited!!");
        } 
        
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
    
    
    public static int AddInventory(Inventory ID)
    {
        int status = 0;
        
        try
        {
                Connection con = InventoryTest.getConnection();

                PreparedStatement ps = con.prepareStatement("insert into inventory(Item, Quantity) values (?,?)");
                ps.setString(1, ID.getItem());
                ps.setInt(2,ID.getQuantity());

                status = ps.executeUpdate();

                con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return status; 
    }
     
     
    public static int DeleteInventory(int ID)
    {
        int status = 0;
    
	try
        {
		Connection con = InventoryTest.getConnection();

		PreparedStatement ps = con.prepareStatement("delete from inventory where Inventoryid=?");
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
     
     public static int EditInventory(int ID)
    {
        int status = 0;
        
        Scanner input = new Scanner(System.in);
 
        try
        {
                Connection con = InventoryTest.getConnection();
                
                PreparedStatement ps = con.prepareStatement("update inventory set Item=?, Quantity=? where Inventoryid=?");
                System.out.println();
                
                System.out.print("Please enter new inventory item name: ");
                String nam = input.nextLine();
                ps.setString(1,nam);
                
                
                String val;
                do
                { 
                    System.out.print("Please enter new inventory item quantity: ");
                    val = input.nextLine();
                    if(val.matches("[0-9]+"))
                        break;
                System.out.println("Input entered is not numeric (only integer value), please try agian.");
                }while(true);
                int pri = Integer.parseInt(val);
                ps.setInt(2,pri);
                    
                ps.setInt(3,ID);

                status = ps.executeUpdate();

                con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        } 

        return status; 
    }
  
}
