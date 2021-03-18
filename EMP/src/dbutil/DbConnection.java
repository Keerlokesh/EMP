/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author LENOVO
 */
public class DbConnection {
    private static Connection conn=null;
    static 
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-MBK4A28:1521","project","java");
            System.out.println("Successfully Added ");
            
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Con not connected To DB !","Error!",JOptionPane.ERROR_MESSAGE );
            e.printStackTrace();
            System.exit(1);
        }
    }
        public static Connection getConnection()
        {
            return conn;
        }
        public static void closeConnection()
        {
            try{
                conn.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Not DisConnected !");
            }
        }
    
    
}
