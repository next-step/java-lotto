package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

	@ParameterizedTest(name = "입력받은 구분자를 기준으로 문자열 split 테스트. delimter={0}, text={1}")
	@CsvSource(value = {
		";$1;2;3", "@$1@2@3", ",$1,2,3"
	}, delimiter = '$')
	void splitTest(final String delimiter, final String text){
		assertThat(StringUtils.split(delimiter, text))
			.containsExactly("1", "2", "3");
	}

	@ParameterizedTest(name = "split이 불가능한 테스트 케이스. delimiter={0}, text={1}")
	@CsvSource(value = {
		"$", "$1;2;3", ";$"
	}, delimiter = '$')
	void splitTestFailedTest(final String delimiter, final String text){
		assertThat(StringUtils.split(delimiter, text))
			.isEmpty();
	}
}
