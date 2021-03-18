/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dbutil.DbConnection;
import pojo.Emp;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class EmpDao {
    public static boolean addEmp(Emp e) throws SQLException {
        
        Connection conn = DbConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("Insert into Employee values(?,?,?)");
        pst.setInt(1,e.getEmpNo());
        pst.setString(2,e.getEmpname());
        pst.setDouble(3,e.getEmpsalary());
        int result = pst.executeUpdate();
        if(result==1)
        {
            return true;
            
        }
        return false;
        
    }
    public static Emp findEmployeeById(int empNo)throws SQLException
    {
        Connection conn= DbConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("Select * from Employee where empid =?");
        pst.setInt(1, empNo);
        ResultSet rs = pst.executeQuery();
        Emp e =null;
        if(rs.next()){
            e= new Emp();
            e.setEmpNo(rs.getInt(1));
            e.setEmpname(rs.getString(2));
            e.setEmpsalary(rs.getDouble(3));
            
        }
        return e;
    }
    public static ArrayList<Emp> getAllEmployee() throws SQLException{
        Connection conn = DbConnection.getConnection();
        Statement st = conn.createStatement();
        ArrayList<Emp> ar = new ArrayList<>();
        ResultSet rs = st.executeQuery("select * from employee");
        while (rs.next())
        {
            Emp e=new Emp();
            e.setEmpNo(rs.getInt(1));
            e.setEmpname(rs.getString(2));
            e.setEmpsalary(rs.getDouble(3));
            ar.add(e);
            
        }
        return ar;
        
    }
    public static boolean deleteEmployeeById(int empNo)throws SQLException
    {
        Connection conn= DbConnection.getConnection();
        Statement st = conn.createStatement();
        st.executeQuery("delete from Employee where empid="+empNo);
        return true;
    }
    public static boolean updateEmployee(Emp e)throws SQLException
    {
        Connection conn= DbConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("Update employee set ename=? , sal=? where empid=?");
        pst.setString(1, e.getEmpname());
        pst.setDouble(2, e.getEmpsalary());
        pst.setInt(3, e.getEmpNo());
        pst.executeUpdate();
        return true;
    }
}
