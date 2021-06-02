package kht2199.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kht2199.lotto.entity.Lotto;
import kht2199.lotto.entity.LottoNumber;
import kht2199.lotto.entity.LottoWinningResult;
import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;
import kht2199.lotto.exception.number.LottoNumberLengthException;
import kht2199.lotto.exception.number.LottoNumberRangeException;

class LottoWinningResultTest {

	@ParameterizedTest
	@DisplayName("보너스 번호 설정. 당첨번호와 중복되지 않고 당첨번호가 이미 설정되어 있어야 한다.")
	@MethodSource("bonusNumberSource")
	void bonusNumber(Lotto winningNumbers, LottoNumber bonusNumber, Class<? extends Exception> exception) {
		assertThatThrownBy(() -> new LottoWinningResult(winningNumbers, bonusNumber))
			.isInstanceOf(exception);
	}

	static Stream<Arguments> bonusNumberSource() throws LottoNumberRangeException, LottoNumberLengthException {
		return Stream.of(
			Arguments.of(LottoNumber.valuesOf(1,2,3,4,5,6), LottoNumber.valueOf(1), LottoBonusNumberDuplicatedException.class) // 보너스번호가 번호에서 중복될 경우
		);
	}
}