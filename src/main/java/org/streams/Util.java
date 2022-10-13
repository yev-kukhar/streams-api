package org.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {
    public static List<Employee> getEmployees() {
        return List.of(
                new Employee("Ivan", 10000, Speciality.ENGINEER),
                new Employee("Petro", 11000, Speciality.ENGINEER),
                new Employee("Vasiliy", 15000, Speciality.MANAGER),
                new Employee("Vladislav", 8500, Speciality.MANAGER),
                new Employee("Maksim", 12000, Speciality.SRE),
                new Employee("Artur", 12300, Speciality.SRE)
        );
    }

    public static void printSpecialists(List<Employee> specialists) {
        specialists.forEach(System.out::println);
    }

    public static List<Employee> filterBySpeciality(List<Employee> employeeList, Speciality speciality) {
        return employeeList.stream()
                .filter(employee -> employee.getSpeciality().equals(speciality))
                .collect(Collectors.toList());
    }

    public static List<Employee> sortEmployeesListByNameAsc(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    public static List<Employee> sortEmployeesListByNameDesc(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList());
    }

    public static List<Employee> sortEmployeesListByNameAndSalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public static Employee findWithMaxSalary(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }
    public static void findAndPrintWithMaxSalary(List<Employee> employees) {
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
    }

    public static Employee findWithMinSalary(List<Employee> employees) {
        return employees.stream()
                .min(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    public static Map<Speciality, List<Employee>> groupBySpeciality(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getSpeciality));
    }

    public static Boolean matchAllEngineers(List<Employee> employees) {
        return employees.stream().allMatch(employee -> employee.getSpeciality().equals(Speciality.ENGINEER));
    }

    public static Boolean matchAnyEngineer(List<Employee> employees) {
        return employees.stream().anyMatch(employee -> employee.getSpeciality().equals(Speciality.ENGINEER));
    }

    public static Boolean matchNoneSalaryMoreThen(List<Employee> employees, Double salary) {
        return employees.stream().noneMatch(employee -> employee.getSalary().compareTo(salary) > 0);
    }

    public static Boolean matchAllHaveSalaryMoreThan(List<Employee> employees, Double salary) {
        return employees.stream().allMatch(employee -> employee.getSalary().compareTo(salary) > 0);
    }

}
