package stringAddCalculator;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String inputText = InputView.inputText();
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.add(inputText);
        OutputView.displayResult(result);
    }
}
