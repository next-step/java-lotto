package kht2199.lotto;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import kht2199.lotto.entity.Rank;
import kht2199.lotto.entity.LottoNumber;
import kht2199.lotto.exception.LottoBonusNumberDuplicatedException;
import kht2199.lotto.exception.LottoWinningNumberNotInitiatedException;
import kht2199.lotto.exception.number.LottoNumberException;
import kht2199.lotto.exception.number.LottoNumberLengthException;
import kht2199.lotto.exception.number.LottoNumberRangeException;

class LottoWinningResultTest {

	// @ParameterizedTest
	// @DisplayName("당첨번호와 단일 로또의 일치 갯수")
	// @MethodSource("calculateSource")
	// void calculate(Lotto lotto, Rank rank) throws
	// 		LottoBonusNumberDuplicatedException,
	// 		LottoWinningNumberNotInitiatedException, LottoNumberException {
	// 	Lotto winningResult = LottoNumber.valuesOf(1, 2, 3, 4, 5, 6);
	// 	LottoWinningResult result = new LottoWinningResult();
	// 	result.setWinningNumbers(winningResult);
	// 	result.setBonusNumber(LottoNumber.valueOf(7));
	// 	assertThat(result.calculateMatched(lotto))
	// 		.isEqualTo(rank);
	// }

	static Stream<Arguments> calculateSource() throws LottoNumberException {
		return Stream.of(
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 4, 5, 6), Rank.FIRST),
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 4, 5, 7), Rank.SECOND),
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 4, 5, 8), Rank.THIRD),
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 4, 8, 9), Rank.FOURTH),
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 8, 9, 10), Rank.FIFTH),
			Arguments.of(LottoNumber.valuesOf(7, 8, 9, 10, 11, 12), Rank.MISS)
		);
	}

	// @ParameterizedTest
	// @DisplayName("보너스 번호 설정. 당첨번호와 중복되지 않고 당첨번호가 이미 설정되어 있어야 한다.")
	// @MethodSource("bonusNumberSource")
	// void bonusNumber(Lotto winningNumbers, LottoNumber bonusNumber, Class<? extends Exception> exception) throws
	// 	LottoBonusNumberDuplicatedException,
	// 	LottoWinningNumberNotInitiatedException {
	// 	LottoWinningResult result = new LottoWinningResult();
	// 	if (exception != null) {
	// 		assertThatThrownBy(() -> result.setBonusNumber(bonusNumber))
	// 			.isInstanceOf(exception);
	// 		return;
	// 	}
	// 	result.setBonusNumber(bonusNumber);
	// }

	static Stream<Arguments> bonusNumberSource() throws LottoNumberRangeException, LottoNumberLengthException {
		return Stream.of(
			Arguments.of(LottoNumber.valuesOf(1,2,3,4,5,6), LottoNumber.valueOf(7), null), // 정상적인 경우
			Arguments.of(LottoNumber.valuesOf(1,2,3,4,5,6), LottoNumber.valueOf(1), LottoBonusNumberDuplicatedException.class), // 보너스번호가 번호에서 중복될 경우
			Arguments.of(null, LottoNumber.valueOf(7), LottoWinningNumberNotInitiatedException.class) // 당첨번호가 설정되어 있지 않은 경우
		);
	}
}