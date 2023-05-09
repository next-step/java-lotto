package step1;

public class Main {
    public static void main(String[] args) {
        final InputView inputView = new InputView();

        final String input = inputView.requestExpression();
        final Expression expression = new Expression(input);
        final int result = new StringSequenceCalculator().calculate(expression);

        final ResultView resultView = new ResultView();
        resultView.print(result);
    }
}
