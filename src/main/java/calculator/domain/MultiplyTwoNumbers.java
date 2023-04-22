package calculator.domain;

public class MultiplyTwoNumbers extends AbstractTwoNumbersCalculator {

    public MultiplyTwoNumbers(Integer num1, Integer num2) {
        super(num1, num2);
    }

    @Override
    public int calculateTwoNumbers() {
        return super.num1 * super.num2;
    }
}
