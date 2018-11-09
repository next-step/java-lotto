package calculator;

public class StringCalculator {
    public int add(String text) {
        Calculator calculator = new Calculator();
        return calculator.getSum(text);
    }


}
