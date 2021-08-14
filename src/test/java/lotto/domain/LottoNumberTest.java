package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoNumberValidationException;

class LottoNumberTest {

	@Test
	@DisplayName("동일 벨류일 경우 동일 객체")
	void equalLottoNumber() {
		assertThat(LottoNumber.valueOf(1) == LottoNumber.valueOf(1)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, -1, 100, 46, -100})
	@DisplayName("로또 번호가")
	void lottoNumberValidFailTest(int value) {
		assertThatExceptionOfType(LottoNumberValidationException.class)
			.isThrownBy(() -> LottoNumber.valueOf(value))
			.withMessage("로또 번호가 잘못 되었습니다.");
	}
}