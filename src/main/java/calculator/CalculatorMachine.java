package calculator;

public class CalculatorMachine {
    public static void main(String[] args) {
        try {
            ResultView.printResult(TextBasedCalculator.calculate(InputView.getStringInput()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
