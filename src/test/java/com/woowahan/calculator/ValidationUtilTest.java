package com.woowahan.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ValidationUtilTest {

	@DisplayName("isNullOrEmpty 메소드는 빈 문자열 또는 null 값을 입력할 경우 true를 반환")
	@ParameterizedTest
	@NullAndEmptySource
	void nullOrEmpty(String input) {

		boolean expected = true;

		boolean result = ValidationUtil.isNullOrEmpty(input);
		assertThat(result).isEqualTo(expected);
	}
}