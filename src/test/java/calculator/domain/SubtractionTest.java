package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.Expression;
import calculator.domain.Digit;
import calculator.domain.Subtraction;

public class SubtractionTest {
	@DisplayName("두 숫자를 빼서 값을 리턴한다.")
	@Test
	void 두_숫자를_뺀다() {
		String input = "3 - 2";
		Expression expression = Expression.create(input);
		Subtraction subtraction = new Subtraction();
		Digit expectingResult = new Digit(1);

		assertThat(subtraction.operate(expression.indexOfDigits(0),
			expression.indexOfDigits(1)).equals(expectingResult)).isTrue();
	}
}
