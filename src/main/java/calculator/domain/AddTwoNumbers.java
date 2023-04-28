package calculator.domain;

public class AddTwoNumbers implements TwoNumbersCalculator {

    @Override
    public int calculateTwoNumbers(int number1, int number2) {
        return number1 + number2;
    }
}
