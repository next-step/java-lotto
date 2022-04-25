package util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {

	@DisplayName("입력문자를 정수로 변환")
	@CsvSource(value = {"1:1", "302:302"}, delimiter = ':')
	@ParameterizedTest
	public void test(String text, int expected) {
		assertThat(Parser.toInt(text)).isEqualTo(expected);
	}

	@DisplayName("입력문자를 정수로 변환할 수 없는 경우 RuntimeException 발생")
	@ValueSource(strings = {"1.4" ,"+", "string"})
	@ParameterizedTest
	public void test(String text) {
		assertThatThrownBy(() -> Parser.toInt(text))
			.isInstanceOf(RuntimeException.class);
	}
}
