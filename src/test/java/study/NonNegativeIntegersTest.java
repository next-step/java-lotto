package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NonNegativeIntegersTest {

	@ParameterizedTest
	@CsvSource(value = {"1,2:3;6", "4,5,6;15", "7:8:9;24"}, delimiter = ';')
	void sum_default_delimiter(String input, int expected) {
		StringSplitter splitter = new StringSplitter(new Delimiter(""), input);
		NonNegativeIntegers integers = new NonNegativeIntegers(splitter.get());

		assertThat(integers.sum()).isEqualTo(expected);
	}

	@Test
	void sum() {
		StringSplitter splitter = new StringSplitter(new Delimiter(";"), "4;5;6");
		NonNegativeIntegers integers = new NonNegativeIntegers(splitter.get());

		assertThat(integers.sum()).isEqualTo(15);
	}
}
