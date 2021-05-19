package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NonNegativeIntegerTest {

	@Test
	void negative_integer() {
		assertThatThrownBy(() ->
			new NonNegativeInteger("-1")
		).isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,1", "999,999"}, delimiter = ',')
	void get(String input, int expected) {
		NonNegativeInteger nonNegativeInteger = new NonNegativeInteger(input);

		assertThat(nonNegativeInteger.get()).isEqualTo(expected);
	}
}
