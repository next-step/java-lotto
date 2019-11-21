package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {
	private StringAddCalculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new StringAddCalculator();
	}

	@Test
	void check_0_or_null() {
		assertThat(calculator.add(null)).isEqualTo(0);
		assertThat(calculator.add("")).isEqualTo(0);
	}

	@Test
	void minusCheck() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.add("-1,2,3");
		});
	}

	@Test
	void customDelimiterTest() {
		calculator.add("//;\n1,2,3");
		assertThat(calculator.hasDelimiter(",")).isTrue();
		assertThat(calculator.hasDelimiter(":")).isTrue();
		assertThat(calculator.hasDelimiter(";")).isTrue();
		assertThat(calculator.hasDelimiter("?")).isFalse();
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2|3", "4:5|9", "1,2:3|6"}, delimiter = '|')
	void delimiterTest(String text, int result) {
		assertThat(calculator.add(text)).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"1|1", "5|5", "1,2,3|6", "'//a\n1a2a3a4'|10"}, delimiter = '|')
	void addTest(String text, int result) {
		assertThat(calculator.add(text)).isEqualTo(result);
	}
}
