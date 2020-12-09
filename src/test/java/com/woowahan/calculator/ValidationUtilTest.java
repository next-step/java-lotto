package com.woowahan.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilTest {

	@DisplayName("isNullOrEmpty 메소드는 빈 문자열 또는 null 값을 입력할 경우 true를 반환")
	@ParameterizedTest
	@NullAndEmptySource
	void nullOrEmpty(String input) {

		boolean expected = true;

		boolean result = ValidationUtil.isNullOrEmpty(input);
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("checkNotANumberAndNegative메서드는 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,-3", "1,-2,-3", "-1,-2,-3", "a,2,3", "1,a,3", "1,2,a", "a,b,c", "-1,-2,a"})
	void checkNotANumberAndNegative(String input) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> {
				ValidationUtil.checkNotANumberAndNegative(input);
			}).withMessage(ValidationUtil.MSG_NOT_A_NUMBER_OR_NEGATIVE);
	}
}