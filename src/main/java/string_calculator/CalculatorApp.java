package string_calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        try {
            InputView i = new InputView();
            String equation = i.scan();
            i.parse(equation);
            Arithmetic a = new Arithmetic();
            Integer result = a.computes(i.values);
            ResultView.print(result);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
