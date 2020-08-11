package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class StringAdderTest {

	@DisplayName("null or empty string이 오면 0 반환")
	@ParameterizedTest
	@ValueSource(strings = {"null",""})
	void testNullOrEmpty(String string) {
		if("null".equals(string)) string = null;
		assertThat(StringAdder.calculate(string)).isEqualTo(0);
	}
}
