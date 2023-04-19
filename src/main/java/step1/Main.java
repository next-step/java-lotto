package step1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final NumberParser numberParser = new NumberParser();
        final OperatorParser operatorParser = new OperatorParser();
        final InputView inputView = new InputView(numberParser, operatorParser);

        inputView.request();
        final List<Integer> numbers = inputView.getNumbers();
        final List<String> operators = inputView.getOperators();

        final int result = new StringSequenceCalculator(numbers, operators).calculate();

        final ResultView resultView = new ResultView();
        resultView.print(result);
    }
}
