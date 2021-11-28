package calculator;

public class Calculator {
    public static final String DELIMITER = ",|:";

    private final Numbers numbers;
    private final int sum;

    public Calculator(Numbers numbers, int sum) {
        this.numbers = numbers;
        this.sum = sum;
    }
}
