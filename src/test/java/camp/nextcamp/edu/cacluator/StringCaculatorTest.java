package camp.nextcamp.edu.cacluator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.calculator.module.StringAddCalculator;

public class StringCaculatorTest {

	private static final String TOKENIZER_REGEX = "[,:]";

	@ParameterizedTest
	@DisplayName(", : 로 문자열 스플릿")
	@ValueSource(strings = {"2,3", "2:3"})
	void split_문자열(String input) {
		assertThat(input.split(TOKENIZER_REGEX))
			.contains("2", "3");
	}

	@ParameterizedTest
	@DisplayName("문자열로 (, | : ) 으로 split 후 모든 문자 덧셈")
	@CsvSource(value = {"2,3=5", "10:3=13", "10:7=17"}, delimiter = '=')
	void split_문자열_add(String input, int expected) {
		int result = Arrays.stream(input.split(TOKENIZER_REGEX))
			.map(Integer::parseInt)
			.reduce(0, (acc, cur) -> acc + cur);

		assertThat(result).isEqualTo(expected);
	}

	@Test
	@DisplayName("calculate \"\" or null return 0")
	void 계산_빈문자열_null() {
		assertAll(
			() -> assertThat(StringAddCalculator.splitAndSum(null))
				.isEqualTo(0),
			() -> assertThat(StringAddCalculator.splitAndSum(""))
				.isEqualTo(0)
		);
	}

	@Test
	void splitAndSum_숫자하나() throws Exception {
		int result = StringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	void splitAndSum_쉼표구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	void splitAndSum_custom_구분자() throws Exception {
		int result = StringAddCalculator.splitAndSum("//;\\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
