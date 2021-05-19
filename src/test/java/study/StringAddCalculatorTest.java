package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {

	StringAddCalculator stringAddCalculator = new StringAddCalculator();

	@DisplayName("null 이나 빈 문자열을 전달하면 0을 반환하는 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	public void splitAndSum_nullOrEmpty(String input) {
		// when
		int actual = stringAddCalculator.splitAndSum(input);

		// then
		assertThat(actual).isEqualTo(0);
	}

	@DisplayName("숫자 문자열을 전달하면 숫자를 그대로 반환하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"0;0", "1;1"}, delimiter = ';')
	public void splitAndSum_onlyNumber(String input, int expected) {
		// when
		int actual = stringAddCalculator.splitAndSum(input);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("숫자와 기본 구분자(',', ':')로 구성된 문자열을 전달하면 숫자를 더하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1,2;3", "4,5:6;15", "7:8:9;24"}, delimiter = ';')
	public void splitAndSum_default_delimiter(String input, int expected) {
		// when
		int actual = stringAddCalculator.splitAndSum(input);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("숫자와 지정한 구분자로 구성된 문자열을 전달하면 숫자를 더하는 테스트")
	@Test
	public void splitAndSum_custom_delimiter() {
		// given
		String input = "//;\n1;2;3";

		// when
		int actual = stringAddCalculator.splitAndSum(input);

		// then
		assertThat(actual).isEqualTo(6);
	}

	@DisplayName("숫자 중에 음수가 있으면 예외가 발생하는 테스트")
	@Test
	public void splitAndSum_negative() {
		// given
		String input = "-1,2,3";

		// then
		assertThatThrownBy(() -> stringAddCalculator.splitAndSum(input)).isInstanceOf(RuntimeException.class);
	}

}
