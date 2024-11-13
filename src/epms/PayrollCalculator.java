package epms;

@FunctionalInterface
public interface PayrollCalculator {
    double calculate(Employee employee);
}
