package calculator;

public class CalculateController {
    public static void main(String[] args) {
        String input = new InputView().getInput();

        int sum = Calculator.getInstance()
                .calculate(input);

        new PrintView().print(sum);
    }
}
