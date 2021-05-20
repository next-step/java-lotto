package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class NonNegativeIntegersTest {

	@DisplayName("빈 문자열을 구분자로 전달하면 기본 구분자로 숫자 패턴에서 숫자를 분리해서 더하는지 확인하는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1,2:3;6", "4,5,6;15", "7:8:9;24"}, delimiter = ';')
	void sum_default_delimiter(String input, int expected) {
		// given
		String delimiterText = "";

		// when
		StringSplitter splitter = new StringSplitter(delimiterText);
		NonNegativeIntegers integers = new NonNegativeIntegers(splitter.split(input));

		// then
		assertThat(integers.sum()).isEqualTo(expected);
	}

	@DisplayName("구분자 문자열을 전달하면 해당 구분자로 숫자 패턴에서 숫자를 분리해서 더하는지 확인하는 테스트")
	@Test
	void sum() {
		// given
		String delimiterText = ";";
		String input = "4;5;6";

		// when
		StringSplitter splitter = new StringSplitter(delimiterText);
		NonNegativeIntegers integers = new NonNegativeIntegers(splitter.split(input));

		// then
		assertThat(integers.sum()).isEqualTo(15);
	}

	@DisplayName("음수를 전달했을 때 예외가 발생하는지 확인하는 테스트")
	@Test
	void negative_integer() {
		// given
		String[] numberText = {"-1"};

		// then
		assertThatThrownBy(() ->
				new NonNegativeIntegers(numberText)
		).isInstanceOf(IllegalArgumentException.class);
	}

}
