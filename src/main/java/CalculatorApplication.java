public class CalculatorApplication {
    public static void main(String[] args) {
        String expression = InputView.getExpression();
        CalculatorInput input = new CalculatorInput(expression);
        int result = ArithmeticCalculator.calculate(input);
        ResultView.showResult(result);
    }
} 