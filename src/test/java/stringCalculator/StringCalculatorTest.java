package stringCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {

	@DisplayName("사칙연산 기호에 따라 연산을 진행한다.")
	@ParameterizedTest
	@CsvSource(value = {"1 + 2:3", "3 - 1:2", "2 * 3:6","6 / 2:3"}, delimiter = ':')
	void calculateByBasicOperations(String str, int result) {
		assertThat(new StringCalculator(str).calculate()).isEqualTo(result);
	}

	@DisplayName("사칙연산 순서를 무시하고 앞에서부터 연산한다.")
	@Test
	void ignore_standard_basic_operation_rule() {
		assertThat(new StringCalculator("10 + 3 * 6 - 4 / 2").calculate()).isEqualTo(37);
	}

	@DisplayName("입력값이 NULL이나 공백일 경우 IllegalArgumentException을 던진다.")
	@ParameterizedTest
	@NullAndEmptySource
	void cant_input_null_or_empty(String input) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new StringCalculator(input).calculate());
	}

	@DisplayName("공백으로 문자열을 나눴을 때 홀수번째 문자열은 숫자입니다.")
	@Test
	void odd_is_number() {
		assertThatThrownBy(() -> new StringCalculator("10 10 -").calculate())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("공백으로 문자열을 나눴을 때 짝수번째 문자열은 사칙연산 기호입니다.")
	@Test
	void even_is_operation() {
		assertThatThrownBy(() -> new StringCalculator("10 - -").calculate())
			.isInstanceOf(NumberFormatException.class);
	}
}
