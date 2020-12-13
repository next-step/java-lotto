package com.woowahan.lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.woowahan.lotto.constant.Message;

class LottoNoTest {

	@DisplayName("of 메서드에 로또 번호의 단일 숫자 값을 입력하면 LottoNo객체를 생성할 수 있다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 5, 10, 15, 20, 25, 30, 40, 45})
	void of(int number){

		LottoNo result = LottoNo.of(number);

		assertThat(result).isInstanceOf(LottoNo.class);
	}

	@DisplayName("of 메서드에 로또 번호(1 ~ 45) 이외의 단일 숫자 값을 입력하면 IllegalArgumentException이 발생한다.")
	@ParameterizedTest
	@ValueSource(ints = {0, 46, -1, -45})
	void ofThrow(int number){

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				LottoNo.of(number);
			}).withMessage(Message.MSG_ERROR_LOTTO_NUMBER);

	}
}