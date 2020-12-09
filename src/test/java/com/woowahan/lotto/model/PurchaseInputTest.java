package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.woowahan.lotto.constant.Message;

class PurchaseInputTest {

	@DisplayName("of 메서드는 1000의 배수의 숫자로된 문자 값을 전달 받으면 PurchaseInput 인스턴스를 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1000", "2000", "3000", "10000", "1000000"})
	void of(String value) {

		PurchaseInput result = PurchaseInput.of(value);
		assertThat(result).isInstanceOf(PurchaseInput.class);
	}

	@DisplayName("of 메서드에 숫자가 아닌 문자 또는 null 또는 empty문자를 전달하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"a", "!", "a3517"})
	void ofNotNumber(String value) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(value);
			}).withMessage(Message.MSG_WRONG_NUMBER);
	}

	@DisplayName("of 메소드는 0또는 음수 문자를 입력하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"0", "-5", "-100"})
	void ofZeroOrNegative(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(value);
			}).withMessage(Message.MSG_WRONG_NUMBER);
	}

	@DisplayName("of 메소드 1000으로 나누어서 나머지가 남는 값을 전달할 경우 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(strings = {"11", "1001", "10010"})
	void existRemainder(String value) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				PurchaseInput.of(value);
			}).withMessage(Message.MSG_WRONG_NUMBER);
	}

}