package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class StringSeparatorTest {

	@ParameterizedTest
	@NullSource
	@EmptySource
	void default_delimiter(String input) {
		StringSeparator separator = new StringSeparator(input, "1,2:3");

		assertThat(separator.split()).containsExactly("1", "2", "3");
	}

	@Test
	void custom_delimiter() {
		StringSeparator separator = new StringSeparator("!", "4!5!6");

		assertThat(separator.split()).containsExactly("4", "5", "6");
	}
}
