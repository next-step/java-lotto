package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivisionTest {
	@DisplayName("두 숫자를 더하여 값을 리턴한다.")
	@Test
	void 두_숫자를_나눈다() {
		String input = "3 / 2";
		Expression expression = Expression.of(input);
		Division division = new Division();
		Digit expectingResult = new Digit(1);

		assertThat(division.operate(expression.indexOfDigits(0),
			expression.indexOfDigits(1)).equals(expectingResult)).isTrue();
	}
}
