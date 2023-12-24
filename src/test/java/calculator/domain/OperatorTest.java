package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {
	@DisplayName("식의 +연산자를 리턴한다")
	@Test
	void 식에_PLUS기호를_포함한다() {
		String input = "1 + 2";
		Expression expression = Expression.of(input);
		Operator operator = Operator.PLUS;

		assertThat(expression.operators()).contains(operator);
	}
}
