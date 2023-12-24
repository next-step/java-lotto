package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DigitTest {
	@DisplayName("두 숫자를 더하여 결과값 리턴")
	@Test
	void 두_숫자를_더한다() {
		Digit first = new Digit(4);
		Digit second = new Digit(3);
		Digit expectingResult = new Digit(7);

		assertThat(first.add(second)).isEqualTo(expectingResult);
	}
}
