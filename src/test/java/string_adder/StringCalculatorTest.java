package string_adder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@Test
	void sum_null() {
		assertThat(stringCalculator.sum(null)).isEqualTo(0);
	}

	@Test
	void sum_빈문자열() {
		assertThat(stringCalculator.sum("")).isEqualTo(0);
	}
}
