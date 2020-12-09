package com.woowahan.lotto.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilTest {

	@DisplayName("isNotNumber 메소드는 숫자가 아닌 문자 또는 null 또는 empty를 입력하면 true를 반환한다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"a", "!", "a3517"})
	void isNotNumber(String input) {

		boolean expected = true;
		boolean result = ValidationUtil.isNotNumber(input);

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("isZeroOrNegative 메소드는 0또는 음수 문자를 입력하면 true를 반환한다. 아니면 false를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"0:true", "-1:true", "-100:true", "1:false", "100:false"}, delimiter = ':')
	void isZeroOrNegative(String input, boolean expected) {

		boolean result = ValidationUtil.isZeroOrNegative(input);

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("existRemainder 메소드는 value 파라미터에 divider로 나눈 나머지가 0아 아니면 true를 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1000:100:false", "1000:11:true", "-100:1000:true"}, delimiter = ':')
	void existRemainder(int value, int divider, boolean expected) {

		boolean result = ValidationUtil.existRemainder(value, divider);

		assertThat(result).isEqualTo(expected);
	}

}