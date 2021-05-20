package wootecam.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilsTest {
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {""})
	@DisplayName("빈문자열이 null, 빈문자열이면 true반환을 테스트")
	void 빈문자열_null테스트(String input) {
		assertThat(StringUtils.isBlank(input)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"test", "asd", "woowa"})
	@DisplayName("빈문자열이 빈값이 아니면 false 반환 테스트")
	void 문자열있으면_false(String input) {
		assertThat(StringUtils.isBlank(input)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"29", "9", "139", "0"})
	@DisplayName("입력 순자열이 0이상의 정수이면 true 반환 테스트")
	void 숫자이면_true(String input) {
		assertThat(StringUtils.isNumeric(input)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"@t", "t", "t13", "-9"})
	@DisplayName("0이상 정수가 아니면 false 반환")
	void 숫자가_아니면_false(String input) {
		assertThat(StringUtils.isNumeric(input)).isFalse();
	}
}