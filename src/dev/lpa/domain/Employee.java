package dev.lpa.domain;

import java.util.Comparator;

public class Employee {

    public static class EmployeeComparator <T extends Employee> implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }



    private int employeeID;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeID, String name, int yearStarted) {
        this.employeeID = employeeID;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeID, name, yearStarted);
    }






}
