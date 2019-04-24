/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reevan
 */
package components;

import java.sql.*;

public class Conn 
{
    Connection con;
    Statement stm;
    public Conn()
    {
        try
        { 
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?autoReconnect=true&useSSL=false","root","rmmjis@sql");
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);     
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }   
}
