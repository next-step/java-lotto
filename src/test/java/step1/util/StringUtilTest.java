package step1.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

	@ParameterizedTest
	@NullAndEmptySource
	void testNullOrEmpty(String nullOrEmpty) {
		assertThat(StringUtil.isNullOrEmpty(nullOrEmpty)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {" 1, 2 :1,2", "a b, c:ab,c"}, delimiter = ':')
	void testRemoveSpace(String input, String expect) {
		assertThat(StringUtil.removeSpace(input)).isEqualTo(expect);
	}
}