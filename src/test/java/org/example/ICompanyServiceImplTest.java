package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/*
  @author   Sofiia
  @project   lab3
  @class  ICompanyServiceImplTest
  @version  1.0.0 
  @since 22.02.2024 - 22.01
*/class ICompanyServiceImplTest {

    private  final Company main = new Company(null, 2);
    private  final Company book = new Company(main, 3);
    private  final Company manager = new Company(main, 4);
    private  final Company developer = new Company(manager, 8);
    private  final Company design = new Company(manager, 6);
    private  final Company lawyer = new Company(null, 1);
    private final ICompanyService companyService = new ICompanyServiceImpl();
    //private final List<Company> list = List.of(main,book,manager, developer, design);
    List<Company> companies = List.of(main, book, manager, developer, design, lawyer);

    @Test
    void whenCompanyIsNull() {
        Company result = companyService.getTopLevelParent(null);
        Assertions.assertNull(result);
    }

    @Test
    void whenCompanyHasNoParentThanOnTop() {
        Company result = companyService.getTopLevelParent(main);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsSingleThanOnTop() {
        Company result = companyService.getTopLevelParent(lawyer);
        Assertions.assertEquals(lawyer, result);
    }
     @Test
    void whenCompanyHasOneStepToTheTopThanFindTop() {
        Company result = companyService.getTopLevelParent(book);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyHasTwoStepToTheTopThanFindTop() {
        Company result = companyService.getTopLevelParent(developer);
        Assertions.assertEquals(main, result);
    }


    @Test
    void whenCompanyMainThen23() {
        long totalEmployees = companyService.getEmployeeCountForCompanyAndChildren(main, companies);

        Assertions.assertEquals(23, totalEmployees);
    }


    @Test
    void whenCompanyManagerThen18() {
        long totalEmployees = companyService.getEmployeeCountForCompanyAndChildren(manager, companies);

        Assertions.assertEquals(18, totalEmployees);
    }
    @Test
    void whenCompanyLawyerThen1() {
        long totalEmployees = companyService.getEmployeeCountForCompanyAndChildren(lawyer, companies);

        Assertions.assertEquals(1, totalEmployees);
    }
    @Test
    void whenCompanyBookThen3() {
        long totalEmployees = companyService.getEmployeeCountForCompanyAndChildren(book, companies);

        Assertions.assertEquals(3, totalEmployees);
    }
    @Test
    void whenCompanyDeveloperThen8() {
        long totalEmployees = companyService.getEmployeeCountForCompanyAndChildren(developer, companies);

        Assertions.assertEquals(8, totalEmployees);
    }
    @Test
    void whenCompanyDesignThen6() {
        long totalEmployees = companyService.getEmployeeCountForCompanyAndChildren(design, companies);

        Assertions.assertEquals(6, totalEmployees);
    }
    @Test
    void whenCompanyIsNullThen0() {
        long totalEmployees = companyService.getEmployeeCountForCompanyAndChildren(null, companies);

        Assertions.assertEquals(0, totalEmployees);
    }

}