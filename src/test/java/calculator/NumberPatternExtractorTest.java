package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberPatternExtractorTest {

	@DisplayName("null 이나 빈 문자열을 전달했을 때 빈 구분자와 숫자 패턴을 기본 값으로 반환하는지 확인하는 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	void getNumberText_default(String pattern) {
		// when
		NumberPatternExtractor extractor = new NumberPatternExtractor(pattern);

		// then
		assertThat(extractor.getDelimiterText()).isEmpty();
		assertThat(extractor.getNumberText()).isEqualTo("0");
	}

	@DisplayName("구분자를 지정하지 않은 패턴을 전달했을 때 빈 구분자와 숫자 패턴을 그대로 반화하는지 확인하는 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
	void getNumberText(String pattern) {
		// when
		NumberPatternExtractor extractor = new NumberPatternExtractor(pattern);

		// then
		assertThat(extractor.getDelimiterText()).isEmpty();
		assertThat(extractor.getNumberText()).isEqualTo(pattern);
	}

	@DisplayName("구분자를 지정한 패턴을 전달했을 때 구분자와 숫자 패턴을 분리해서 반환하는지 확인하는 테스트")
	@Test
	void getNumberText_customDelimiter() {
		// given
		String str = "//!\n1!2!3";

		// when
		NumberPatternExtractor extractor = new NumberPatternExtractor(str);

		// then
		assertThat(extractor.getDelimiterText()).isEqualTo("!");
		assertThat(extractor.getNumberText()).isEqualTo("1!2!3");
	}

}
