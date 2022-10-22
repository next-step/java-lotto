package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	void only_certain_operators_are_allowed() {
		List<String> expressionsWithAllowedOperators = List.of("1 + 2 / 3 - 1 * 2".split(SINGLE_SPACE));

		assertThatNoException().isThrownBy(() -> new Calculator(expressionsWithAllowedOperators));
	}

	@Test
	@DisplayName("허용되지 않은 사칙연산 기호는 오류를 발생시킨다")
	void not_allowed_operators_throws_exception() {
		List<String> expressionsWithNotAllowedOperators = List.of("1 + 2 ^ 3 @ 4".split(SINGLE_SPACE));

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Calculator(expressionsWithNotAllowedOperators));
	}

	@ParameterizedTest(name = "입력 순서대로 사칙연산을 할 수 있다 {index}")
	@CsvSource(value = {"2 + 3 * 4 / 2 = 10", "22 + 3 * 4 / 2 = 50"}, delimiterString = " = ")
	void calculate_between_numbers(String rawExpressions, int expectedNumber) {
		List<String> expressions = List.of(rawExpressions.split(SINGLE_SPACE));
		Calculator calculator = new Calculator(expressions);

		assertThat(calculator.calculate()).isEqualTo(expectedNumber);
	}
}
