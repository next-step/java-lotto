package calculator;

import calculator.model.Expression;
import calculator.view.UserView;

public class CalculatorMain {

	private static final int ILLEGAL_EXCEPTION_SUM_VALUE = 0;

	public static void main(String[] args) {

		try {

			Expression calculator = UserView.getUserInputExpression();
			UserView.printCalculateResult(calculator.sum());
		} catch (IllegalArgumentException illegalArgumentException) {

			UserView.printErrorMsg(illegalArgumentException.getMessage());
			UserView.printCalculateResult(ILLEGAL_EXCEPTION_SUM_VALUE);
		} catch (RuntimeException runtimeException) {

			UserView.printErrorMsg(runtimeException.getMessage());
		}
	}
}
