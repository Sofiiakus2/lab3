package org.example;/*
  @author   Sofiia
  @project   lab3
  @class  Company
  @version  1.0.0 
  @since 22.02.2024 - 21.58
*/

public class Company {

    private Company parent;
    private long employeeCount;


    public Company(Company parent, long employeeCount) {
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }
}
