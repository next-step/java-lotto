package calculator.view;

import calculator.model.Expression;
import calculator.util.StringValid;

public class UserView {

	public static Expression getUserInputExpression() {

		UserOutput.printUserInputExpression();

		return new Expression(getUserInputSystem());
	}

	private static String getUserInputSystem() {

		String userInputExpression = UserInput.userInputString();

		if (StringValid.isAddSeparator(userInputExpression)) {
			userInputExpression += (UserOutput.NEXT_LINE_FLAG + UserInput.userInputString());
		}

		return userInputExpression;
	}

	public static void printCalculateResult(int sumValue) {

		UserOutput.printCalculateResult(sumValue);
	}

	public static void printErrorMsg(String message) {

		UserOutput.printUserErrorMsg(message);
	}
}
