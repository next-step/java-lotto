package stringcalculator;

public class App {

    private App() {
    }

    public static int calculate(String input) {
        var calculator = new StringCalculator(new Input(input));
        return calculator.calculate();
    }
}
