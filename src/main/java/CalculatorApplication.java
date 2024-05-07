public class CalculatorApplication {
    private final Calculator calculator = new Calculator();

    public int calculate(String text) {
        return calculator.calculate(Digits.of(text), Operators.of(text));
    }
}
