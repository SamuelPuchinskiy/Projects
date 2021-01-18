package inventory;

import java.sql.*;


public class Inventory 
{
    int Inventoryid;
    String Item;
    int Quantity;
    
     public Inventory(   
                int Inventoryid,
                String Item,
                int Quantity
                )
    {
        this.Inventoryid = Inventoryid;
        this.Item = Item;
        this.Quantity = Quantity;
   
    }
        
    public int getInventoryid()
    {
        return this.Inventoryid;
    }
    public void setInventoryid(int Inventoryid)
    {
        this.Inventoryid = Inventoryid;
    }
    
     public String getItem()
    {
        return this.Item;
    }
    public void setItem(String Item)
    {
        this.Item = Item;
    }
    
     public int getQuantity()
    {
        return this.Quantity;
    }
    public void setQuantity(int Quantity)
    {
        this.Quantity = Quantity;
    }   
}