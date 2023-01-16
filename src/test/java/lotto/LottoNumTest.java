package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.LottoNum;
import lotto.exception.InvalidRangeOfLottoNumException;

class LottoNumTest {

	@DisplayName("로또 숫자는 1~45 사이 숫자가 아니면 예외를 던진다.")
	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	void Should_Throw_Exception_When_Number_Is_Not_Between_1_And_45(int value) {
		Assertions.assertThatThrownBy(() -> {
			LottoNum lottoNum = LottoNum.of(value);
		}).isInstanceOf(InvalidRangeOfLottoNumException.class);
	}
}
