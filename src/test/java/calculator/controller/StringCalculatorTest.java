package calculator.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.Expression;
import calculator.domain.Digit;

public class StringCalculatorTest {
	@DisplayName("사칙연산을_하여_값을 리턴한다.")
	@Test
	void 사칙연산을_수행한다() {
		String input = "4 * 2 * 3 - 4 / 3";
		Expression expression = new Expression(input);
		Digit expectingResult = new Digit(6);

		assertThat(StringCalculator.calculate(expression).equals(expectingResult)).isTrue();
	}
}
