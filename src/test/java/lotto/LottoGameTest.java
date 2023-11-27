package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGameTest {
	@ParameterizedTest
	@NullSource
	@DisplayName("LottoList 는 아무런 로또번호가 주어지지 않으면 예외를 던진다")
	void newObject_nullLottoList_throwsException(LottoList nullLottoList) {
		LottoWinningNumbers lottoWinningNumbers
				= new LottoWinningNumbers(new Lotto(), new LottoNumber(4));

		assertThatThrownBy(
				() -> new LottoGame(nullLottoList, lottoWinningNumbers)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@NullSource
	@DisplayName("LottoList 는 아무런 로또 당첨 번호가 주어지지 않으면 예외를 던진다")
	void newObject_nullLottoWinningNumbers_throwsException(LottoWinningNumbers nullWinningNumbers) {
		LottoList lottoList = new LottoList(3);

		assertThatThrownBy(
				() -> new LottoGame(lottoList, nullWinningNumbers)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("rateOfReturn 는 주어진 로또번호와 정답을 비교해 수익률을 계산해 반환한다.")
	void rateOfReturn_lottoListAndWinningLotto_lottoResultAndRateOfReturn() {
		Lotto lottoOne = new Lotto("1, 2, 3, 4, 5, 6");
		Lotto lottoTwo = new Lotto("7, 8, 6, 11, 12, 13");
		Lotto winningLotto = new Lotto("4, 5, 6, 11, 12, 13");
		LottoNumber bonusNumber = new LottoNumber(15);
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningLotto, bonusNumber);
		LottoList lottoList = new LottoList(List.of(lottoOne, lottoTwo));

		LottoGame lottoGame = new LottoGame(lottoList, lottoWinningNumbers);
		double rateOfReturn = lottoGame.rateOfReturn();

		assertEquals(rateOfReturn, 2750.0, 0.001);
	}
}
