package string_calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        try {
            String equation = InputView.scan();
            Parser parser = new Parser();
            parser.parse(equation);
            Calculator a = new Calculator();
            Integer result = a.computes(parser.values);
            ResultView.print(result);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
