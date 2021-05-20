package StringAddCalculator;

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
}
