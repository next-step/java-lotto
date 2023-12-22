package calculator;

import static calculator.view.InputView.*;
import static calculator.view.ResultView.*;
import static calculator.controller.Calculator.*;

import calculator.domain.Expression;

public final class StringCalculatorApplication {
	public static void main(String[] args) {
		printExpressionInput();
		Expression expression = new Expression(inputText());
		printResult(calculate(expression));
	}
}
