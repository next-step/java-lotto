package operations;

public interface CalculateStrategy {
    public boolean match(String operation);

    int calculate(int number1, int number2);
}
