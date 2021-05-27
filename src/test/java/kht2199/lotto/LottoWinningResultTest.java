package kht2199.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kht2199.lotto.data.Lotto;
import kht2199.lotto.exception.LottoNumberDuplicatedException;
import kht2199.lotto.exception.LottoNumberNotInitiatedException;
import kht2199.lotto.exception.LottoNumberSizeInvalidException;

class LottoWinningResultTest {

	@ParameterizedTest
	@DisplayName("당첨번호와 단일 로또의 일치 갯수")
	@MethodSource("calculateSource")
	void calculate(List<Integer> winningResult, Lotto lotto, int matched) throws LottoNumberSizeInvalidException {
		LottoWinningResult result = new LottoWinningResult();
		result.setWinningNumbers(winningResult);
		assertThat(result.calculateMatched(lotto))
			.isEqualTo(matched);
	}

	static Stream<Arguments> calculateSource() {
		List<Integer> winningResult = List.of(1, 2, 3, 4, 5, 6);
		return Stream.of(
			Arguments.of(winningResult, new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
			Arguments.of(winningResult, new Lotto(List.of(1, 2, 3, 4, 5, 7)), 5),
			Arguments.of(winningResult, new Lotto(List.of(7, 8, 9, 10, 11, 12)), 0)
		);
	}

	@ParameterizedTest
	@DisplayName("보너스 번호 설정. 당첨번호와 중복되지 않고 당첨번호가 이미 설정되어 있어야 한다.")
	@MethodSource("bonusNumberSource")
	void bonusNumber(List<Integer> winningNumbers, int bonusNumber, Class<? extends Exception> exception) throws
			LottoNumberDuplicatedException,
			LottoNumberNotInitiatedException {
		LottoWinningResult result = new LottoWinningResult();
		try {
			result.setWinningNumbers(winningNumbers);
		} catch (LottoNumberSizeInvalidException e) {
			// ignore
		}
		if (exception != null) {
			assertThatThrownBy(() -> result.setBonusNumber(bonusNumber))
				.isInstanceOf(exception);
			return;
		}
		result.setBonusNumber(bonusNumber);
	}

	static Stream<Arguments> bonusNumberSource() {
		return Stream.of(
			Arguments.of(List.of(1,2,3,4,5,6), 7, null), // 정상적인 경우
			Arguments.of(List.of(1,2,3,4,5,6), 1, LottoNumberDuplicatedException.class), // 보너스번호가 번호에서 중복될 경우
			Arguments.of(null, 7, LottoNumberNotInitiatedException.class) // 당첨번호가 설정되어 있지 않은 경우
		);
	}
}