package org.example;/*
  @author   Sofiia
  @project   lab3
  @class  ICompanyServiceImpl
  @version  1.0.0 
  @since 22.02.2024 - 22.00
*/

import java.util.List;

public class ICompanyServiceImpl implements ICompanyService {
    public Company getTopLevelParent(Company child) {
        if (child == null || child.getParent() == null) {
            return child; // Якщо передано null або батьківська компанія null, повертаємо саму компанію
        }
        Company parent = child.getParent();
        while (parent.getParent() != null) {
            parent = parent.getParent();
        }
        return parent;
    }



    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        if (company == null || !companies.contains(company)) {
            return 0; 
        }
    
        long employeeCount = company.getEmployeeCount();
    
        for (Company child : companies) {
            if (child.getParent() == company) {
                employeeCount += getEmployeeCountForCompanyAndChildren(child, companies);
            }
        }

    
        return employeeCount;
    }
    

}
