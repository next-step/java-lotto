package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.woowahan.lotto.constant.Message;

class WinNumbersTest {

	@DisplayName("of 메서드는 로또번호에 만족하는 6개의 숫자가 쉼표로 구분되는 하나의 문자열을 받으면 WinNumbers 객체를 생성한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "45, 44, 43, 42, 41, 40", "1, 15, 25, 35, 40, 45"})
	void of(String value) {

		WinNumbers result = WinNumbers.of(value);
		assertThat(result).isInstanceOf(WinNumbers.class);
	}

	@DisplayName("of 메서드에 숫자가 아닌 문자 또는 null 또는 empty문자를 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@NullAndEmptySource
	void ofNotNumber(String value) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(value);
			}).withMessage(Message.MSG_NULL_OR_EMPTY);
	}

	@DisplayName("of 메서드에 쉼표로 구분되는 문자가 6개가 아니면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
	void ofLength(String value) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(value);
			}).withMessage(Message.MSG_WRONG_WIN_NUMBER);
	}

	@DisplayName("of 메서드에 쉼표로 구분되는 문자에 숫자가 아닌 문자가 포함되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"a,2,3,4,5,6", "null,2,3,4,5,6", "1,,3,4,5,6"})
	void ofHasNotNumber(String value) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(value);
			}).withMessage(Message.MSG_WRONG_WIN_NUMBER);
	}

	@DisplayName("of 메서드에 쉼표로 구분되는 문자에 1과 45 사이가 아닌 문자가 포함되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"0,2,3,4,5,6", "1,2,3,4,5,46"})
	void ofHasWrongNumber(String value) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				WinNumbers.of(value);
			}).withMessage(Message.MSG_WRONG_WIN_NUMBER);
	}

}