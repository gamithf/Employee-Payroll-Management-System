package epms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PayrollSystem {
    private List<Employee> employees;

    public PayrollSystem() {
        this.employees = new ArrayList<>();
        initializeEmployees();
    }

    private void initializeEmployees() {
        employees.add(new FullTimeEmployee(1, "Alice", "HR", 60000, 5000));
        employees.add(new FullTimeEmployee(2, "Bob", "IT", 80000, 7000));
        employees.add(new PartTimeEmployee(3, "Charlie", "Sales", 50, 120));
        employees.add(new PartTimeEmployee(4, "Diana", "IT", 60, 100));
}

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> filterByDepartment(String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public List<Employee> filterBySalary() {
        return employees.stream()
                .sorted((employee1, employee2) -> Double.compare(employee2.getSalary(), employee1.getSalary()))
                .collect(Collectors.toList());
    }

    public double calculateTotalPayroll(PayrollCalculator calculator) {
        return employees.stream()
                .mapToDouble(calculator::calculate)
                .sum();
    }

    public Optional<Employee> getHighestPaidEmployee() {
        return employees.stream()
                .max((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()));
    }

    public double calculateTotalTax(double taxRate) {
        return employees.stream()
                .mapToDouble(emp -> emp.getSalary() * taxRate)
                .sum();
    }
}
