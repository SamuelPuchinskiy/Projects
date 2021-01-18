/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;
import java.sql.*;

/**
 *
 * @author bilalq
 */
public class ProfileUser 
{
    int userID;
    String firstName;
    String lastName;
    int age;
    String email;
    String userName;
    String passWord;
    String cell;

    public ProfileUser(int userID, String firstName, String lastName, int age, String email, String userName, String passWord, String cell) 
    {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.cell = cell;
    }
    
    ProfileUser()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getUserID() 
    {
        return userID;
    }

    public void setUserID(int userID) 
    {
        this.userID = userID;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }
    
    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getUserName() 
    {
        return this.userName;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getPassword() 
    {
        return this.passWord;
    }

    public void setPassword(String passWord) 
    {
        this.passWord = passWord;
    }
    
    public String getCell() 
    {
        return this.cell;
    }

    public void setCell(String cell) 
    {
        this.cell = cell;
    }
    
    
}
