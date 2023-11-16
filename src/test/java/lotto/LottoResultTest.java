package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {
	@Test
	void matched() {
		long purchaseAmount = 14000;
		Lotto lottoOne = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lottoTwo = new Lotto(List.of(7, 8, 6, 11, 12, 13));
		Lotto winningLotto = new Lotto(List.of(4, 5, 6, 11, 12, 13));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningLotto);
		LottoList lottoList = new LottoList(List.of(lottoOne, lottoTwo));

		LottoResult lottoResult = new LottoResult(purchaseAmount);
		lottoResult.matchesWinningNumbers(lottoList, lottoWinningNumbers);

		Map<LottoMatch, Integer> matchResult = lottoResult.result();
		assertThat(matchResult.get(LottoMatch.THREE)).isEqualTo(1);
		assertThat(matchResult.get(LottoMatch.FOUR)).isEqualTo(1);
		assertEquals(lottoResult.rateOfReturn(), 300, 0.001);
	}
}
