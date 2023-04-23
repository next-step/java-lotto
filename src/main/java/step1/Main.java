package step1;

public class Main {
    public static void main(String[] args) {
        final InputView inputView = new InputView();

        final String input = inputView.request();

        final int result = new StringSequenceCalculator().calculate(input);

        final ResultView resultView = new ResultView();
        resultView.print(result);
    }
}
