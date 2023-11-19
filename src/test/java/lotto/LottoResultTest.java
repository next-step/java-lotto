package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {
	@ParameterizedTest
	@NullSource
	@DisplayName("LottoList 는 아무런 로또번호가 주어지지 않으면 예외를 던진다")
	void newObject_nullLottoList_throwsException(LottoList nullLottoList) {

		assertThatThrownBy(
				() -> new LottoResult(nullLottoList)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("matchesWinningNumbers 는 주어진 로또번호와 정답을 비교해 맞춘 번호의 갯수별 합과 수익률을 계산한다.")
	void matchesWinningNumbers_lottoListAndWinningLotto_lottoResultAndRateOfReturn() {
		Lotto lottoOne = new Lotto("1, 2, 3, 4, 5, 6");
		Lotto lottoTwo = new Lotto("7, 8, 6, 11, 12, 13");
		Lotto winningLotto = new Lotto("4, 5, 6, 11, 12, 13");
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningLotto);
		LottoList lottoList = new LottoList(List.of(lottoOne, lottoTwo));

		LottoResult lottoResult = new LottoResult(lottoList);
		lottoResult.matchesWinningNumbers(lottoWinningNumbers);

		Map<LottoMatch, Integer> lottoMatchResult = lottoResult.lottoMatchMap();
		assertThat(lottoMatchResult.get(LottoMatch.THREE)).isEqualTo(1);
		assertThat(lottoMatchResult.get(LottoMatch.FOUR)).isEqualTo(1);
		assertEquals(lottoResult.rateOfReturn(), 2700, 0.001);
	}
}
