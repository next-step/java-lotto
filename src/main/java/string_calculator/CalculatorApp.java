package string_calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        try {
            String equation = InputView.scan();
            Parser p = new Parser();
            p.parse(equation);
            Calculator a = new Calculator();
            Integer result = a.computes(p.values);
            ResultView.print(result);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
