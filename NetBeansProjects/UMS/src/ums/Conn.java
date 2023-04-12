
package ums;

import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        
        
        try{
            
            //Creating a driver claSS 
            Class.forName("com.mysql.cj.jdbc.Driver");//till jdbc it is the name of the package and after that it is a class 
            //Creating a connection string - mentioning the information of the database
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/ums","root", "Dihar@1234"); 
            s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
//5 steps of JDBC connection 
//Register the driver class
//creating a connection string 
//creating the statement 
//Executing the SQL queries 
//Closing the connection