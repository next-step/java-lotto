package string_calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        try {
            String equation = InputView.scan();
            Parser parser = new Parser();
            parser.parse(equation);
            Calculator calculator = new Calculator();
            Integer result = calculator.computes(parser.values);
            ResultView.print(result);
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
