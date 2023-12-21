package calculator.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.controller.Multiplication;
import calculator.domain.Expression;
import calculator.domain.Number;

public class MultiplicationTest {
	@DisplayName("두 숫자를 곱하여 값을 리턴한다.")
	@Test
	void 두_숫자를_곱한다() {
		Expression expression = new Expression("3 * 2");
		Multiplication multiplication = new Multiplication();
		Number number1 = new Number(3);
		Number number2 = new Number(2);
		Number number3 = new Number(6);
		assertThat(expression.numbers().get(0).equals(number1)).isTrue();
		assertThat(expression.numbers().get(1).equals(number2)).isTrue();
		assertThat(multiplication.multiply(expression.numbers().get(0), expression.numbers().get(1)).equals(number3)).isTrue();
	}
}
