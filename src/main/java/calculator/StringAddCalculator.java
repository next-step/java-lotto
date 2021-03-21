package calculator;

public class StringAddCalculator {

    public int calculate(String text) {
        PositiveNumbers positiveNumbers = new PositiveNumbers(text);
        return positiveNumbers.sum();
    }

}
