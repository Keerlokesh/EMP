/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author LENOVO
 */
public class Emp {
    
    public Emp()
    {
        
    }
    public Emp(int empNo, String empname, double empsalary) {
        this.empNo = empNo;
        this.empname = empname;
        this.empsalary = empsalary;
    }
    private int empNo;
    private String empname;
    private double empsalary;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public double getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(double empsalary) {
        this.empsalary = empsalary;
    }
}
