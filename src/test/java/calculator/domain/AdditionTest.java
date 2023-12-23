package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdditionTest {
	@DisplayName("두 숫자를 더하여 값을 리턴한다.")
	@Test
	void 두_숫자를_더한다() {
		String input = "1 + 2";
		Expression expression = Expression.of(input);
		Addition addition = new Addition();
		Digit expectingResult = new Digit(3);

		assertThat(addition.operate(expression.indexOfDigits(0),
			expression.indexOfDigits(1)).equals(expectingResult)).isTrue();
	}
}
