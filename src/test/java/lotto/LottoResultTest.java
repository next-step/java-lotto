package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
	@Test
	void matched() {
		Lotto lottoOne = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		Lotto lottoTwo = new Lotto(List.of(7, 8, 6, 11, 12, 13));
		Lotto winningLotto = new Lotto(List.of(4, 5, 6, 11, 12, 13));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningLotto);
		LottoList lottoList = new LottoList(List.of(lottoOne, lottoTwo));

		LottoResult lottoResult = new LottoResult();
		lottoResult.matchesWinningNumbers(lottoList, lottoWinningNumbers);

		Map<LottoMatch, Integer> matchResult = lottoResult.result();

		assertThat(matchResult.get(LottoMatch.valueOf("THREE"))).isEqualTo(1);
		assertThat(matchResult.get(LottoMatch.valueOf("FOUR"))).isEqualTo(1);
	}
}
