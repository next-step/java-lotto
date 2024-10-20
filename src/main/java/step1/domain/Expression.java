package step1.domain;

import java.util.regex.Pattern;

import step1.exception.UserInputEmptyException;
import step1.exception.UserInputUnValidException;

public class Expression {
	private static final Pattern spacePattern = Pattern.compile("^\\-*\\d( [\\+\\-\\*\\/\\%] \\-*\\d)+$");

	private final String expression;

	public Expression(String userInput) {
		if (isEmpty(userInput)) {
			throw new UserInputEmptyException();
		}
		if (!isValid(userInput)) {
			throw new UserInputUnValidException();
		}
		this.expression = userInput;
	}

	private static boolean isEmpty(String userInput) {
		return userInput.isEmpty();
	}

	private static boolean isValid(String userInput) {
		return spacePattern.matcher(userInput).matches();
	}

	public String get() {
		return expression;
	}
}
