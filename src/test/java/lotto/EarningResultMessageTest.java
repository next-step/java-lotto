package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class EarningResultMessageTest {

	@ParameterizedTest
	@CsvSource(value = {"-1:손해", "1:이득", "0:본전"}, delimiter = ':')
	void get(int value, String expected) {
		// given
		String message = EarningResultMessage.get(value);

		// then
		assertThat(message).isEqualTo(expected);
	}
}
