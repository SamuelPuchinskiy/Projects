package item;

import java.sql.*;

public class Item 
{
    int Itemid;
    String ItemName;
    int Price;
    String Description;
    
    public Item(   
                int Itemid,
                String ItemName,
                int Price,
                String Description
                )
    {
        this.Itemid = Itemid;
        this.ItemName = ItemName;
        this.Price = Price;
        this.Description = Description;
    }
    
    public int getItemid()
    {
        return this.Itemid;
    }
    public void setItemid(int Itemid)
    {
        this.Itemid = Itemid;
    }
    
    public String getItemName()
    {
        return this.ItemName;
    }
    public void setItemName(String ItemName)
    {
        this.ItemName = ItemName;
    }
    
    public int getPrice()
    {
        return this.Price;
    }
    public void setPrice(int Price)
    {
        this.Price = Price;
    }
    
    public void setDescription(String Description)
    {
        this.Description = Description;
    }
    
    public String getDescription()
    {
        return this.Description;
    }
}