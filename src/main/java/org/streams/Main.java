package org.streams;

import java.util.List;
import java.util.Map;

import static org.streams.Util.*;

public class Main {
    public static void main1(String[] args) {
        //get all ENGINEERS
        printSpecialists(filterBySpeciality(getEmployees(), Speciality.ENGINEER));
    }

    public static void main2(String[] args) {
        //sorting by name
        printSpecialists(sortEmployeesListByNameAsc(getEmployees()));
        System.out.println("===================");
        printSpecialists(sortEmployeesListByNameDesc(getEmployees()));
        System.out.println("===================");
        //sorting by name and salary
        printSpecialists(sortEmployeesListByNameAndSalary(getEmployees()));
    }

    public static void main3(String[] args) {
        // min-max salary
        System.out.println((findWithMaxSalary(getEmployees())));
        System.out.println("===================");
        System.out.println((findWithMinSalary(getEmployees())));
        System.out.println("===================");
        findAndPrintWithMaxSalary(getEmployees());
    }

    public static void main4(String[] args) {
        // grouping by speciality
        Map<Speciality, List<Employee>> groupedBySpeciality = groupBySpeciality(getEmployees());
        System.out.println(groupedBySpeciality);
    }

    public static void main5(String[] args) {
        // is all engineers in collection?
        System.out.println(matchAllEngineers(getEmployees()));
        System.out.println("========================");
        // at least one engineer in collection?
        System.out.println(matchAnyEngineer(getEmployees()));
    }

    public static void main6(String[] args) {
        // no one with salary more than?
        System.out.println(matchNoneSalaryMoreThen(getEmployees(), 12000.0));
        System.out.println("===========================");
        // is all have salary more than?
        System.out.println(matchAllHaveSalaryMoreThan(getEmployees(), 2000.0));
    }
}