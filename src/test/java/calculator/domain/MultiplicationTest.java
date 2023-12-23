package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.Expression;
import calculator.domain.Digit;
import calculator.domain.Multiplication;

public class MultiplicationTest {
	@DisplayName("두 숫자를 곱하여 값을 리턴한다.")
	@Test
	void 두_숫자를_곱한다() {
		String input = "3 * 2";
		Expression expression = Expression.create(input);
		Multiplication multiplication = new Multiplication();
		Digit expectingResult = new Digit(6);

		assertThat(multiplication.operate(expression.indexOfDigits(0),
			expression.indexOfDigits(1)).equals(expectingResult)).isTrue();
	}
}
