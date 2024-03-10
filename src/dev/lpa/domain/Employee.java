package dev.lpa.domain;

public class Employee {
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
