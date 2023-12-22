package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Expression {
	private static final char PLUS = '+';
	private static final char MINUS = '-';
	private static final char MULTIPLY = '*';
	private static final char DIVISION = '/';
	private final List<Digit> digits;
	private final List<Operator> operators;

	public Expression(String input) {
		digits = new ArrayList<>();
		operators = new ArrayList<>();
		String[] strings = input.split(" ");
		for (String string : strings) {
			parseExpression(string);
		}
	}

	public List<Digit> numbers() {
		return digits;
	}

	public List<Operator> operators() {
		return operators;
	}

	private void parseExpression(String string) {
		char character = string.charAt(0);
		if (character == PLUS || character == MINUS || character == MULTIPLY || character == DIVISION) {
			operators.add(new Operator(character));
		}
		if (Character.isDigit(character)) {
			digits.add(new Digit(character - '0'));
		}
	}

	public Digit indexOfDigits(int index) {
		return digits.get(index);
	}

	public Operator indexOfOperators(int index) {
		return operators.get(index);
	}

	public void insertDigit(int index, Digit digit) {
		digits.set(index, digit);
	}
}
