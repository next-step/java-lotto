package domain.operations;

public interface CalculateStrategy {
    public boolean match(String operation);

    int calculate(Number number1, Number number2);
}
