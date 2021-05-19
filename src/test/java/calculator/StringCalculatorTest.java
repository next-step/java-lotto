package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

	@Test
	@DisplayName(value = "null 혹은 empty string 을 전달하면 0을 반환한다")
	void emptyString() {
		int empty = StringCalculator.sumByDelimiter("");
		int inputNull = StringCalculator.sumByDelimiter(null);
		assertThat(empty).isEqualTo(0);
		assertThat(inputNull).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:123", "1:1", "01:1"}, delimiter = ':')
	@DisplayName(value = "구분자가 없는 숫자인 경우 숫자로 변경해 반환한다")
	void noDelimiter(String text, int value) {
		int result = StringCalculator.sumByDelimiter(text);
		assertThat(result).isEqualTo(value);
	}

}
