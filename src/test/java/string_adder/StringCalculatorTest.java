package string_adder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SuppressWarnings("NonAsciiCharacters")
class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@ParameterizedTest
	@NullSource
	@EmptySource
	void sum_nullOrEmpty(String text) {
		assertThat(stringCalculator.sum(text)).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"0=0", "1=1", "999=999"}, delimiter = '=')
	void sum_숫자한개(String number, int expected) {
		assertThat(stringCalculator.sum(number)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,1=1", "2:999=1001"}, delimiter = '=')
	void sum_숫자두개(String twoNumbers, int expected) {
		assertThat(stringCalculator.sum(twoNumbers)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,1:2=3", "2:1:0,5,1000=1008"}, delimiter = '=')
	void sum_숫자여러개(String multipleNumbers, int expected) {
		assertThat(stringCalculator.sum(multipleNumbers)).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"5,-1", "0,-1:-5"})
	void sum_음수_예외발생(String numbers) {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> stringCalculator.sum(numbers));
	}

	@Test
	void sum_커스텀구분자() {
		assertThat(stringCalculator.sum("//\\+\n1+5")).isEqualTo(6);
		assertThat(stringCalculator.sum("//;;;\n1;;;5")).isEqualTo(6);
		assertThat(stringCalculator.sum("//ab\n5ab10")).isEqualTo(15);
	}
}
