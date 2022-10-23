package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExpressionsTest {

	private static final String SINGLE_SPACE = " ";

	@Test
	@DisplayName("수식은 null일 수 없다")
	void expressions_itself_is_not_null() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Expressions(null));
	}

	@Test
	@DisplayName("수식은 공백을 포함할 수 없다")
	void expressions_is_not_containing_blank() {
		List<String> expressions = List.of(" ", "  ");

		assertThatIllegalArgumentException().isThrownBy(() -> new Expressions(expressions));
	}

	@ParameterizedTest(name = "순서대로 사칙연산을 할 수 있다 {index}")
	@CsvSource(value = {"2 + 3 * 4 / 2 = 10", "22 + 3 * 4 / 2 = 50"}, delimiterString = " = ")
	void calculate_expressions_sequentially(String rawExpressions, int expectedNumber) {
		Expressions expressions = new Expressions(splitExpressions(rawExpressions));

		assertThat(expressions.calculate()).isEqualTo(expectedNumber);
	}

	private List<String> splitExpressions(String rawExpressions) {
		return List.of(rawExpressions.split(SINGLE_SPACE));
	}
}