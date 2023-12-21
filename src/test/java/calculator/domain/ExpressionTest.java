package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionTest {
	@DisplayName("두 숫자를 더하여 값을 리턴한다.")
	@Test
	void 식을_분리한다() {
		Expression expression = new Expression("1 + 2");
		Number number1 = new Number(1);

		assertThat(expression.numbers().contains(number1)).isTrue();
	}
}
