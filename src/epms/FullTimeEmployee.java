package epms;

public class FullTimeEmployee extends Employee {
    private double bonus;
    public FullTimeEmployee(int id, String name, String department, double baseSalary, double bonus) {
        super(id, name, department, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return this.getSalary() + bonus;
    }
}
