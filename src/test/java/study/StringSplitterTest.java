package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class StringSplitterTest {

	@ParameterizedTest
	@NullSource
	@EmptySource
	void default_delimiter(String input) {
		StringSplitter separator = new StringSplitter(new Delimiter(input), "1,2:3");

		assertThat(separator.get()).containsExactly("1", "2", "3");
	}

	@Test
	void custom_delimiter() {
		StringSplitter separator = new StringSplitter(new Delimiter("!"), "4!5!6");

		assertThat(separator.get()).containsExactly("4", "5", "6");
	}
}
