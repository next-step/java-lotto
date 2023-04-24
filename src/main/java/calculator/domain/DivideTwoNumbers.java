package calculator.domain;

public class DivideTwoNumbers implements TwoNumbersCalculator {

    @Override
    public int calculateTwoNumbers(int number1, int number2) {
        return number1 / number2;
    }
}
