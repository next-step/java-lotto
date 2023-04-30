package stringCalculator;

public class CalculatorMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String[] input = inputView.init();
        StringCalculator cal = new StringCalculator(input);

        resultView.print(cal.calculate());
    }
}
