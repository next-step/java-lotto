package calculator;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String userInput = inputView.getUserOperation();

        Calculator calculator = new Calculator(userInput);
        int result = calculator.calculate();

        OutputView.printResult(result);
    }
}
