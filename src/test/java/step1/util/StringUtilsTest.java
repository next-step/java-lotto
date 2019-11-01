package step1.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class StringUtilsTest {

	@Test
	void null은_빈_문자열이라고_간주한다() {
		// given
		String nullString = null;

		// when
		boolean result = StringUtils.isEmpty(nullString);

		// then
		assertThat(result).isTrue();
	}

	@ParameterizedTest
	@CsvSource({",true", "abc,false"})
	void StringUtils는_빈_문자열을_확인할_수_있다(String string, boolean isEmpty) {
		assertThat(StringUtils.isEmpty(string)).isEqualTo(isEmpty);
	}

}
