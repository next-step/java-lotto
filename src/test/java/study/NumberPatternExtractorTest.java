package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberPatternExtractorTest {

	@ParameterizedTest
	@NullSource
	@EmptySource
	void getNumberText_default(String input) {
		NumberPatternExtractor extractor = new NumberPatternExtractor(input);

		assertThat(extractor.getNumberText()).isEqualTo("0");
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
	void getNumberText(String input) {
		NumberPatternExtractor extractor = new NumberPatternExtractor(input);

		assertThat(extractor.getNumberText()).isEqualTo(input);
	}

	@Test
	void getNumberText_customDelimiter() {
		NumberPatternExtractor extractor = new NumberPatternExtractor("//!\n1!2!3");

		assertThat(extractor.getNumberText()).isEqualTo("1!2!3");
	}

	@ParameterizedTest
	@NullSource
	@EmptySource
	void getDelimiter_default(String input) {
		NumberPatternExtractor extractor = new NumberPatternExtractor(input);

		assertThat(extractor.getDelimiterText()).isEqualTo("");
	}

	@Test
	void getDelimiter() {
		NumberPatternExtractor extractor = new NumberPatternExtractor("//#\n4#5#6");

		assertThat(extractor.getDelimiterText()).isEqualTo("#");
	}

}
