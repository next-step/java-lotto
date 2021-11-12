package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoNumberRangeException;

class LottoNumberTest {
	@DisplayName("로또 넘버는 1 ~ 45 사이가 아닐 경우 예외가 발생한다.")
	@ParameterizedTest(name = "{index}. input : {0}")
	@ValueSource(ints = {-1, 0, 46})
	void create(int input) {
		// when then
		Assertions.assertThatExceptionOfType(LottoNumberRangeException.class)
			.isThrownBy(() -> LottoNumber.create(input));
	}
}
