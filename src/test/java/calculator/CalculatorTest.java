package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private static final String SINGLE_SPACE = " ";

	@Test
	@DisplayName("수식은 null일 수 없다")
	void expressions_itself_is_not_null() {
		assertThatThrownBy(() -> new Calculator(null)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("수식은 공백을 포함할 수 없다")
	void expressions_is_not_containing_blank() {
		List<String> expressions = List.of(" ", "  ");
		assertThatThrownBy(() -> new Calculator(expressions)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("사칙연산은 특정 기호만 허용한다")
	void only_certain_operations_are_allowed() {
		List<String> expressionsWithAllowedOperations = List.of("1 + 2 / 3 - 1 * 2".split(SINGLE_SPACE));
		List<String> expressionsWithNotAllowedOperations = List.of("1 + 2 ^ 3 @ 4".split(SINGLE_SPACE));

		assertThatNoException().isThrownBy(() -> new Calculator(expressionsWithAllowedOperations));
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Calculator(expressionsWithNotAllowedOperations));
	}
}
