package nextstep.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	private static final String DELIMITER = " ";
	public static Number calculate(final String input) {

		final String[] s = parse(input);
		final Number number = new Number(s[0]);
		final List<Operation> operations = new ArrayList<>();
		for (int i = 1; i < s.length; i = i + 2) {
			operations.add(new Operation(s[i], s[i + 1]));
		}

		final Expression expression = new Expression(number, operations);
		return expression.calculate();
	}

	private static String[] parse(final String input) {

		if(input == null || input.isBlank()) {
			throw new IllegalArgumentException("표현식은 공백일 수 없습니다.");
		}

		final String[] s = input.split(DELIMITER);

		if(s.length % 2 == 0) {
			throw new IllegalArgumentException("유효하지 않은 포맷입니다.");
		}

		return s;
	}
}
