package org.streams;

public class Employee {

    String name;
    Double salary;
    Speciality speciality;

    public Employee(String name, double salary, Speciality speciality) {
        this.name = name;
        this.salary = salary;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", speciality=" + speciality +
                '}';
    }
}
