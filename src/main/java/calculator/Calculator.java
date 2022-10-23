package calculator;

import java.util.List;

public class Calculator {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();

	public static void main(String[] args) {
		List<String> rawExpressions = inputView.readExpressions();
		Expressions expressions = new Expressions(rawExpressions);
		outputView.printResult(expressions.calculate());
	}
}
