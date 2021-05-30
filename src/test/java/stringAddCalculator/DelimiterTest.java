package stringAddCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterTest {
	@Test
	@DisplayName("구분자의 길이가 2를 초과하거나 특수문자가 아닌 것이 포함되면 에러 발생")
	public void custom_delimiter_length_exceed_two_or_contains_non_special_symbols() {
		assertThatThrownBy(() -> new Delimiter("!@a"))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> new Delimiter("!@a"))
			.isInstanceOf(RuntimeException.class);
	}
}
