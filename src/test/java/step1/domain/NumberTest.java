package step1.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.exception.StringAdderException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTest {

	@ParameterizedTest
	@CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
	void testConstruct(String stringInput, int intInput) {
		assertThat(new Number(stringInput)).isEqualTo(new Number(intInput));
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "a"})
	void failTestConstruct(String stringInput) {
		assertThrows(StringAdderException.class, () -> new Number(stringInput));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1","2","3"})
	void testIntValue(String stringInput) {
		assertThat(new Number(stringInput).intValue()).isEqualTo(Integer.parseInt(stringInput));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:2:3", "2:4:6"}, delimiter = ':')
	void testSum(String one, String theOther, String result) {
		assertThat(Number.sum(new Number(one), new Number(theOther))).isEqualTo(new Number(result));
	}

}