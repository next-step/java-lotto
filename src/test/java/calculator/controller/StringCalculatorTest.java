package calculator.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.Expression;
import calculator.domain.Number;

public class StringCalculatorTest {
	@DisplayName("다섯 숫자를 더하여 값을 리턴한다.")
	@Test
	void 다섯_숫자를_더한다() {
		StringCalculator stringCalculator = new StringCalculator();
		Expression expression = new Expression("1 + 2 + 3 + 4 + 5");
		Number number1 = new Number(15);

		assertThat(stringCalculator.calculate(expression).equals(number1)).isTrue();
	}
}
