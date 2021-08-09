package lotto.domain.number;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoNumberValidationException;

class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 46, 47, -1})
	@DisplayName("로또 번호 예외 케이스 검증")
	void validLottoNumberFail(int value) {
		assertThatExceptionOfType(LottoNumberValidationException.class)
			.isThrownBy(() -> {
				new LottoNumber(value);
			}).withMessage("로또 번호가 잘못 되었습니다.");
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	@DisplayName("로또 번호 검증 성공")
	void validLottoNumberSuccess(int value) {
		LottoNumber lottoNumber = new LottoNumber(value);

		assertThat(lottoNumber.equals(new LottoNumber(value))).isTrue();
	}
}