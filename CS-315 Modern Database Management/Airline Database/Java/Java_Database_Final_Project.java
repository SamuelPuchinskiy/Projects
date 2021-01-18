/* Samuel Puchinskiy */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Java_Database_Final_Project
{
   public static Scanner input = new Scanner(System.in);
   public static Statement statement;
   public static Connection connection;
   public static ResultSet rs;
   
   public static void main(String[] args) throws Exception
   {
      connection = null;
   
      try
      {
         connection = DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/s19315_samuelpuchinskiy?" + "user=s19315_samuelpuchinskiy&password=" + getPassword());
         statement = connection.createStatement();
         
         System.out.println("\n...\n Welcome! \n...\n");
         
         
         /* SELECTING TABLES OR VIEWS STARTS HERE */
         
         System.out.println("Would you like to view a Table and/or View? \n YES (1) \n NO (2)");
         System.out.print("Type Answer: ");
         int user = input.nextInt();
         boolean value = true;
         
         if(user == 1)
            while(value)
            {
               System.out.println("Which tables or views would you like to select? \n Origin Airports (1) \n Destination Airports (2) \n Airlines (3) \n Hours (4) \n Flight (5) \n Flights Information View (6)" );
                  System.out.print("Type Answer: ");
                     user = input.nextInt();
                  if(user < 7 && user > 0)
                     PrintTable(user);
                  else
                     System.out.println("Value not recognized."); 
               System.out.println("Would you like to see another table? \n YES (1) \n No (2)");
                  System.out.print("Type Answer: ");
                     user = input.nextInt();
               if(user == 1)
                  value = true;
               else if(user == 2)
                  value = false; 
               else
                  System.out.println("Value not recognized.");     
            }
            else if(user != 2)
               System.out.println("Value not recognized."); 
            
            System.out.println("\n...\n Viewing Tables and/or Views Finished \n...\n");
            
            /* SELECTING TABLES OR VIEWS ENDS HERE */
            
            
            /* INSERTING TO TABLES STARTS HERE */
            
            System.out.println("Would you like to insert data to a Table? \n YES (1) \n NO (2)");
            System.out.print("Type Answer: ");
            user = input.nextInt();
            value = true;
            
            if(user == 1)
               while(value)
               {
                  System.out.println("Which tables would you like to insert data to? \n Origin Airports (1) \n Destination Airports (2) \n Airlines (3) \n Hours (4) \n Flight (5)" );
                     System.out.print("Type Answer: ");
                        user = input.nextInt();
                     if(user < 6 && user > 0)
                        InsertData(user);
                     else
                        System.out.println("Value not recognized."); 
                  System.out.println("Would you like to insert data to another table? \n YES (1) \n No (2)");
                     System.out.print("Type Answer: ");
                        user = input.nextInt();
                  if(user == 1)
                     value = true;
                  else if(user == 2)
                     value = false; 
                  else
                     System.out.println("Value not recognized."); 
                          
               }
               else if(user != 2)
                  System.out.println("Value not recognized."); 
        
        
            System.out.println("\n...\n Inserting Data in Tables Finished \n...\n");
            
            /* INSERTING TO TABLES ENDS HERE */
            
            /* UPDATING AIRLINE TABLE STARTS HERE */    
            
            /* Update Flight Table */
            System.out.println("Would you like to update Ticket Price in Airline Table? \n YES (1) \n NO (2)");
            System.out.print("Type Answer: ");
            user = input.nextInt();
            value = true;
            
            if(user == 1)
               while(value)
               {
                  PrintTable(3);
                  
                  System.out.println("Which Airline would you like to update?");
                  System.out.print("Enter the exact Airline number:");
                  int userUpdate = input.nextInt();
                  UpdateAirline(userUpdate);
                  
                   System.out.println("Would you like to update Ticket Price in another Airline table? \n YES (1) \n No (2)");
                     System.out.print("Type Answer: ");
                        user = input.nextInt();
                  if(user == 1)
                     value = true;
                  else if(user == 2)
                     value = false; 
                  else
                     System.out.println("Value not recognized.");   
               }
               else if(user != 2)
                  System.out.println("Value not recognized."); 
                  
             System.out.println("\n...\n Updating Data to Airline Table Finished \n...\n");

                  
            /* UPDATING AIRLINE TABLE ENDS HERE */  
            
            
            /* DELETING FLIGHT TABLE STARTS HERE */  
            System.out.println("Would you like to delete a Flight ID in Flight Table? \n YES (1) \n NO (2)");
            System.out.print("Type Answer: ");
            user = input.nextInt();
            value = true;
            
            if(user == 1)
               while(value)
               {
                  DeleteFlight();
                  
                   System.out.println("Would you like to delete another Flight ID in Flight table? \n YES (1) \n No (2)");
                     System.out.print("Type Answer: ");
                        user = input.nextInt();
                  if(user == 1)
                     value = true;
                  else if(user == 2)
                     value = false; 
                  else
                     System.out.println("Value not recognized.");    
               }
               else if(user != 2)
                  System.out.println("Value not recognized."); 

            System.out.println("\n...\n Deleting Data in Flight Table Finished \n...\n");

            
            /* Deleting FLIGHT TABLE ENDS HERE */ 
             

            System.out.println("\n...\n Thank You! \n Goodbye! \n...\n");
           
      }
      catch(SQLException sqle)
      {
         System.out.println("SQLException: " + sqle.getMessage());
         System.out.println("sqlState: " + sqle.getSQLState());
         System.out.println("VenderError: " + sqle.getErrorCode());
      }
      catch(Exception e)
      {
         System.out.println("Something else went wrong. Restart Program.");
      }   
   }
   
   /* DELETE TABLE*/
   public static void DeleteFlight() throws Exception
   {
         PrintTable(5);
                  
         System.out.println("Which Flight would you like to delete?");
         System.out.println("Enter the exact Flight ID (copy and paste the Flight ID) Format: \"FLIGHT_ID-OA10-DA08-AR08-HR03\"");
         System.out.print("Enter Flight ID: ");
         String userDelete = input.next();
         userDelete = addQuotes(userDelete);
         
         String delete = "DELETE FROM Flights";
         String where = " WHERE flight_id = " + userDelete;
         String sql = delete + where;
         
      System.out.println("Are you sure you want to delete and initiate the following command? " + sql + "\nYES (1) \nNO (2)");
      System.out.print("Enter Answer: ");
      int user = input.nextInt();
      if(user == 1)
      {
         int num = statement.executeUpdate(sql);
         if(num < 0)
         System.out.println("No record(s) were deleted. Check syntax.");
         else
         {
            System.out.println(num + " record(s) were deleted.");
            //PrintTable(5);
         }     
      }
      else
         System.out.println("Did not delete...");
      
      rs.close();
   }// END DELETE HERE

   
   /* UPDATE AIRLINES */
   public static void UpdateAirline(int userUpdate) throws Exception
   {
      System.out.println();
      //userUpdate = addQuotes(userUpdate);
   
      System.out.print("Enter Economy Ticket Cost: ");
      double ET = input.nextDouble();
      
      System.out.print("Enter Business Ticket Cost: ");
      double BT = input.nextDouble();
      
      System.out.print("Enter First Class Ticket Cost: ");
      double FT = input.nextDouble();
      
      String update = "UPDATE Airline";
      String set = " SET air_economyTicketCost = " + ET + ", air_businessTicketCost = " + BT + ", air_firstClassTicketCost = " + FT;
      String where = " WHERE air_id = " + userUpdate + ";";
      
      String sql = update + set + where;
      System.out.println("Are you sure you want to execute the following command? " + sql + "\nYES (1) \nNO (2)");
      System.out.print("Enter Answer: ");
      int user = input.nextInt();
      if(user == 1)
      {
         int num = statement.executeUpdate(sql);
         if(num < 0)
         System.out.println("No record(s)1 were updated. Check syntax.");
         else
         {
            System.out.println(num + " record(s) were updated.");
            //PrintTable(3);
         }     
      }
      else
         System.out.println("Did not update...");
      
      
      
      rs.close();
      

   }// END UPDATE AIRLINE


   /* PRINTING TABLE METHOD */
   public static void PrintTable(int user) throws Exception
   {    
         System.out.println();
         
         if(user == 1) /* ORIGIN AIRPORT */
         {
            String sqlSelect = "SELECT * FROM Origin_Airport";   
            rs = statement.executeQuery( sqlSelect );
            while (rs.next()) 
            {
               int oriA_id = rs.getInt("oriA_id");
               String oriA_name = rs.getString("oriA_name");
               String oriA_country = rs.getString("oriA_country");
               String oriA_state = rs.getString("oriA_state");
               String oriA_city = rs.getString("oriA_city");
               int oriA_zipcode = rs.getInt("oriA_zipcode");
                           
               System.out.println("Origin #" + oriA_id + 
               "  -Name: " + oriA_name + 
               "  -Country: " +  oriA_country +
               "  -State: " + oriA_state +
               "  -City: " + oriA_city +
               "  -Zipcode: " + oriA_zipcode );
               System.out.println();
             }
         }
         else if(user == 2) /* DESTINATION AIRPORT */
         {
            String sqlSelect = "SELECT * FROM Destination_Airport";   
            rs = statement.executeQuery( sqlSelect );   
            while (rs.next()) 
            {
               int destA_id = rs.getInt("destA_id");
               String destA_name = rs.getString("destA_name");
               String destA_country = rs.getString("destA_country");
               String destA_state = rs.getString("destA_state");
               String destA_city = rs.getString("destA_city");
               int destA_zipcode = rs.getInt("destA_zipcode");
                           
               System.out.println("Destination #" + destA_id + 
               "  -Name: " + destA_name + 
               "  -Country: " +  destA_country +
               "  -State: " + destA_state +
               "  -City: " + destA_city +
               "  -Zipcode: " + destA_zipcode );
               System.out.println();
             }
         }
         else if(user == 3) /* AIRLINE */
         {
            String sqlSelect = "SELECT * FROM Airline";   
            rs = statement.executeQuery( sqlSelect );   
            while (rs.next()) 
            {
               int air_id = rs.getInt("air_id");
               String air_name = rs.getString("air_name");
               int air_totalEconomyCapacity = rs.getInt("air_totalEconomyCapacity");
               int air_totalBusinessCapacity = rs.getInt("air_totalBusinessCapacity");
               int air_totalFirstClassCapacity = rs.getInt("air_totalFirstClassCapacity");
               int air_economyTicketCost = rs.getInt("air_economyTicketCost");
               int air_businessTicketCost = rs.getInt("air_businessTicketCost");
               int air_firstClassTicketCost = rs.getInt("air_firstClassTicketCost");
                           
               System.out.println("Airline #" + air_id + 
               "  -Name: " + air_name + 
               "  -Economy Capacity: " +  air_totalEconomyCapacity +
               "  -Business Capacity: " + air_totalBusinessCapacity +
               "  -First Class Capacity: " + air_totalFirstClassCapacity +
               "  -Economy Ticket: $" + air_economyTicketCost + 
               "  -Business Ticket: $" + air_businessTicketCost + 
               "  -First Class Ticket: $" + air_firstClassTicketCost );
               System.out.println();
             }
         }
         else if(user == 4) /* HOURS */
         {
            String sqlSelect = "SELECT * FROM Hours";   
            rs = statement.executeQuery( sqlSelect );   
            while (rs.next()) 
            {
               int hour_id = rs.getInt("hour_id");
               String hour_depature = rs.getString("hour_depature");
               String hour_arrival = rs.getString("hour_arrival");
                           
               System.out.println("Hour #" + hour_id + 
               "  -Depature Time: " + hour_depature +
               "  -Arrival Time: " + hour_depature );
               System.out.println();
             }
         }
         else if(user == 5) /* FLIGHTS */
         {  
            String sqlSelect = "SELECT * FROM Flights";   
            rs = statement.executeQuery( sqlSelect );   
            while (rs.next()) 
            {
               int oriA_id = rs.getInt("oriA_id");
               int destA_id = rs.getInt("destA_id");
               int air_id = rs.getInt("air_id");
               int hour_id = rs.getInt("hour_id");
               String flight_id = rs.getString("flight_id");
                           
               System.out.println("oriA_id #" + oriA_id + 
               "  -destA_id #" + destA_id +
               "  -air_id #" + air_id +
               "  -hour_id #" + oriA_id +
               "  -flight_id #" + flight_id );
               System.out.println();
             }      
         }
         else if(user == 6) /* FLIGHTS INFO */
         {  
            String sqlSelect = "SELECT * FROM Flights_Info";   
            rs = statement.executeQuery( sqlSelect );   
            while (rs.next()) 
            {
               String oriA_name = rs.getString("Origin Airport");
               String destA_name = rs.getString("Destination Airport");
               String air_name = rs.getString("Airline");
               String hour_depature = rs.getString("Depature Time");
               String hour_arrival = rs.getString("Arrival Time");
               String flight_id = rs.getString("Flight ID");
                           
               System.out.println("Origin Airport: " + oriA_name + 
               "  -Destination Airport: " + destA_name +
               "  -Airline: " + air_name +
               "  -Depature Time: " + hour_depature +
               "  -Arrival Time: " + hour_arrival +
               "  -Flight ID: " + flight_id );
               System.out.println();
             }      
         }
         else
            System.out.println("Invalid Answer.");
       
          rs.close();
          
        
   }
   
   
   /* INSERTING DATA METHOD */
   public static void InsertData(int user) throws Exception
   { 
         System.out.println();
         
         if(user == 1) /* ORIGIN AIRPORT */
         {
            System.out.println("\nAdding Origin Airport...\n");
            
            System.out.print("Enter Origin Airport name: ");
            String oName = input.next();
            oName = "'" + oName + "',";
            
            System.out.print("Enter Origin Airport Country: ");
            String oCountry = input.next();
            oCountry = "'" + oCountry + "',";
            
            System.out.print("Enter Origin Airport State: ");
            String oState = input.next();
            oState = "'" + oState + "',";
            
            System.out.print("Enter Origin Airport City: ");
            String oCity = input.next();
            oCity = "'" + oCity + "',";
            
            System.out.print("Enter Origin Airport Zipcode: ");
            String oZip = input.next();
            
            String command = oName + oCountry + oState + oCity + oZip;
 
            String sqlInsert = "INSERT INTO Origin_Airport (oriA_name, oriA_country, oriA_state, oriA_city, oriA_zipcode) VALUES(" + command + ");";
         
            System.out.println(sqlInsert);
            statement.executeUpdate(sqlInsert); 
            System.out.println();
         }
         else if(user == 2) /* DESTINATION AIRPORT */
         {
         
            System.out.println("\nAdding Destination Airport...\n");
            
            System.out.print("Enter Destination Airport name: ");
            String dName = input.next();
            dName = "'" + dName + "',";
            
            System.out.print("Enter Destination Airport Country: ");
            String dCountry = input.next();
            dCountry = "'" + dCountry + "',";
            
            System.out.print("Enter Destination Airport State: ");
            String dState = input.next();
            dState = "'" + dState + "',";
            
            System.out.print("Enter Destination Airport City: ");
            String dCity = input.next();
            dCity = "'" + dCity + "',";
            
            System.out.print("Enter Destination Airport Zipcode: ");
            String dZip = input.next();
            
            String command = dName + dCountry + dState + dCity + dZip;
 
            String sqlInsert = "INSERT INTO Destination_Airport (destA_name, destA_country, destA_state, destA_city, destA_zipcode) VALUES(" + command + ");";
         
            System.out.println(sqlInsert);
            statement.executeUpdate(sqlInsert);
            System.out.println();
         }
         else if(user == 3) /* AIRLINE */
         {
         
            System.out.println("\nAdding Airline...\n");
            
            System.out.print("Enter Airline name: ");
            String aName = input.next();
            aName = "'" + aName + "',";
            
            System.out.print("Enter Total Economy Capacity: ");
            String aEC = input.next();
            aEC = aEC + ",";
            
            System.out.print("Enter Total Business Capacity: ");
            String aBC = input.next();
            aBC = aBC + ",";
            
            System.out.print("Enter Total First Class Capacity: ");
            String aCC = input.next();
            aCC = aCC + ",";
            
            System.out.print("Enter Total Economy Ticket Cost: ");
            String aET = input.next();
            aET = aET + ",";
            
            System.out.print("Enter Total Business Ticket Cost: ");
            String aBT = input.next();
            aBT = aBT + ",";
            
            System.out.print("Enter Total First Class Ticket Cost: ");
            String aCT = input.next();
            aCT = aCT;

            String command = aName + aEC + aBC + aCC + aET + aBT + aCT;
 
            String sqlInsert = "INSERT INTO Airline (air_name, air_totalEconomyCapacity, air_totalBusinessCapacity, air_totalFirstClassCapacity, air_economyTicketCost, air_businessTicketCost, air_firstClassTicketCost) Values(" + command + ");";
         
            System.out.println(sqlInsert);
            statement.executeUpdate(sqlInsert);
            System.out.println();      
       
         }
         else if(user == 4) /* HOURS */
         {
         
            System.out.println("\nAdding Hours...\n");
            
            System.out.print("Enter Depature Time: ");
            String dTime = input.next();
            dTime = "'" + dTime + "',";
            
            System.out.print("Enter Arrival Time: ");
            String aTime = input.next();
            aTime = "'" + aTime + "'";
          
            String command = dTime + aTime;
 
            String sqlInsert = "INSERT INTO Hours (hour_depature, hour_arrival) VALUES(" + command + ");";
         
            System.out.println(sqlInsert);
            statement.executeUpdate(sqlInsert);
            System.out.println();    
             
         }
         else if(user == 5) /* FLIGHTS */
         {  
         
            System.out.println("\nAdding Flights...\n");
            String FlightID = "FLIGHT_ID";
            
            System.out.print("Enter Origin Airport ID: ");
            String oriID = input.next();
            if(oriID.length() == 1)
               FlightID += "-OA0"+oriID;
            else
              FlightID += "-OA"+oriID; 
            oriID = oriID + ",";
            
            System.out.print("Enter Destination Airport ID: ");
            String destID = input.next();
            if(destID.length() == 1)
               FlightID += "-DA0"+destID;
            else
              FlightID += "-DA"+destID; 
            destID = destID + ",";
            
            System.out.print("Enter Airline ID: ");
            String airID = input.next();
            if(airID.length() == 1)
               FlightID += "-AR0"+airID;
            else
              FlightID += "-AR"+airID; 
            airID = airID + ",";
            
            System.out.print("Enter Hours ID: ");
            String hourID = input.next();
            if(hourID.length() == 1)
               FlightID += "-HR0"+hourID;
            else
              FlightID += "-HR"+hourID;    
            hourID = hourID + ",";
            
            FlightID = "'" + FlightID + "'";
            
            String command = oriID + destID + airID + hourID + FlightID;
 
            String sqlInsert = "INSERT INTO Flights (oriA_id, destA_id, air_id, hour_id, flight_id) VALUES(" + command + ");";
         
            System.out.println(sqlInsert);
            statement.executeUpdate(sqlInsert);
            System.out.println();  
      }
      else
            System.out.println("Invalid Answer.");
       
          rs.close();
          
         
   }

   public static String addQuotes(String value)
   {
      String result = "'" + value + "'";
      return result;
   }// end add quotes
   
   
   public static String getPassword()
   {
      return "MySequelPassword2019";
   }
}