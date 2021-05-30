package stringAddCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	@Test
	@DisplayName("빈 문자열 입력 시 0 반환")
	public void input_empty_string_return_0() {
		assertThat(StringAddCalculator.splitAndReturnSum("")).isEqualTo(0);
	}

	@Test
	@DisplayName("null 입력 시 0 반환")
	public void input_null_return_0() {
		assertThat(StringAddCalculator.splitAndReturnSum(null)).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자 하나 입력 시 해당 수 반환")
	public void input_one_number_return_the_number() {
		assertThat(StringAddCalculator.splitAndReturnSum("3")).isEqualTo(3);
	}

	@Test
	@DisplayName("쉼표 혹은 콜론을 구분자로 가지는 문자열 전달 시 구분자 기준으로 분리한 숫자의 합 반환")
	public void input_string_contains_numbers_that_is_separated_by_comma_or_colon_return_sum() {
		assertThat(StringAddCalculator.splitAndReturnSum("1,2")).isEqualTo(3);
		assertThat(StringAddCalculator.splitAndReturnSum("1,2,3")).isEqualTo(6);
		assertThat(StringAddCalculator.splitAndReturnSum("1,2:3")).isEqualTo(6);
	}

	@Test
	@DisplayName("커스텀 구분자 설정")
	public void custom_delimiter_set_up() {
		assertThat(StringAddCalculator.splitAndReturnSum("//;\n1;2;3")).isEqualTo(6);
		assertThat(StringAddCalculator.splitAndReturnSum("//:;\n2:;3:;4")).isEqualTo(9);
	}

	@Test
	@DisplayName("음수나 숫자 외의 값이 입력 되었을 경우 런타임 에러 발생")
	public void input_contains_negative_or_something_that_is_not_number_return_runtime_exception() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndReturnSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> StringAddCalculator.splitAndReturnSum("a,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("1000만 이상의 값이 입력되면 에러 발생")
	public void input_contains_few_numbers_that_are_over_one_million_return_runtime_exception() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndReturnSum("1000000000,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("100개 이상의 값이 입력되면 에러 발생")
	public void input_contains_numbers_that_count_over_one_hundred_return_runtime_exception() {
		StringBuilder input = new StringBuilder();

		for (int i = 0; i < 100; i++) {
			input.append("100,");
		}
		input.append("100");
		assertThatThrownBy(() -> StringAddCalculator.splitAndReturnSum(input.toString()))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("구분자의 길이가 2를 초과하거나 특수문자가 아닌 것이 포함되면 에러 발생")
	public void custom_delimiter_length_exceed_two_or_contains_non_special_symbols() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndReturnSum("//;a\n1;a2;a3"))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> StringAddCalculator.splitAndReturnSum("//;:#\n1;:#2;:#3"))
			.isInstanceOf(RuntimeException.class);
	}
}
