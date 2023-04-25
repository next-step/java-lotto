package calculator;

import calculator.domain.Expression;
import calculator.service.InputParser;
import calculator.view.InputView;
import calculator.view.ResultView;

public class StringCalculatorApplication {

	private static final InputView inputView = new InputView();
	private static final ResultView resultView = new ResultView();
	private static final InputParser inputParser = new InputParser();

	public static void main(String[] args) {

		Expression expression = new Expression(inputParser.parseTokens(inputView.getInput()));

		resultView.printResult(expression.calculate());
	}
}
