import epms.Employee;
import epms.PayrollSystem;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        // Employees of IT Department
        System.out.println("Employees of IT Department: ");
        List<Employee> employeesOfITDepartment = payrollSystem.filterByDepartment("IT");
        employeesOfITDepartment.forEach(System.out::println);
        System.out.println();

        // Employees with sorted order of salary in descending order
        System.out.println("Employees order of descending order of salary: ");
        List<Employee> sortedEmployeesWithSalaryDesc = payrollSystem.filterBySalary();
        sortedEmployeesWithSalaryDesc.forEach(System.out::println);
        System.out.println();

        // Total payroll of employees
        System.out.println("Total payroll of employees: " + payrollSystem.calculateTotalPayroll(Employee::getSalary));
        System.out.println();

        // Total payroll of employees with bonus of Rs. 5000
        System.out.println("Total payroll of employees with bonus of 5000: " + payrollSystem.calculateTotalPayroll(employee -> employee.getSalary() + 5000));
        System.out.println();

        // Highest pain employee
        Optional<Employee> highestPaidEmployee = payrollSystem.getHighestPaidEmployee();
        highestPaidEmployee.ifPresent(System.out::println);
        System.out.println();

        // Calculating total tax with tax rate 15%
        double totalTax = payrollSystem.calculateTotalTax(0.15);
        System.out.println("Total tax with rate of 15%: " + totalTax);
    }
}