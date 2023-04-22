package calculator.domain;

public class MultiplyTwoNumbers implements TwoNumbersCalculator {

    @Override
    public int calculateTwoNumbers(Integer number1, Integer number2) {
        return number1 * number2;
    }
}
