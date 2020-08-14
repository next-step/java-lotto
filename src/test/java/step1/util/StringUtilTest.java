package step1.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

	@DisplayName("null 이거나 빈 문자열 검증 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	void testNullOrEmpty(String nullOrEmpty) {
		assertThat(StringUtil.isNullOrEmpty(nullOrEmpty)).isTrue();
	}

	@DisplayName("문자열 공백 제거 테스트")
	@ParameterizedTest
	@CsvSource(value = {" 1, 2 :1,2", "a b, c:ab,c"}, delimiter = ':')
	void testRemoveSpace(String input, String expect) {
		assertThat(StringUtil.removeSpace(input)).isEqualTo(expect);
	}
}