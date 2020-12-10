package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.woowahan.lotto.constant.Message;

class BonusNumberTest {

	@DisplayName("of 메서드는 1과 45 사이의 숫자를 전달하면 BonusNumber 인스턴스를 반환한다. ")
	@ParameterizedTest
	@ValueSource(strings = {"1", "45", "10", "35", "25"})
	void of(String value) {

		BonusNumber result = BonusNumber.of(value);
		assertThat(result).isInstanceOf(BonusNumber.class);
	}

	@DisplayName("of 메서드에 숫자가 아닌 문자 또는 null 또는 empty문자를 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"a", "!", "a3517"})
	void ofNotNumber(String value) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				BonusNumber.of(value);
			}).withMessage(Message.MSG_WRONG_BONUS_NUMBER);

	}

	@DisplayName("of 메서드에 1에서 45사이가 아닌 숫자인 문자가 전달되면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"0", "46", "-1", "-45"})
	void ofWrongNumber(String value) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				BonusNumber.of(value);
			}).withMessage(Message.MSG_WRONG_BONUS_NUMBER);

	}
}