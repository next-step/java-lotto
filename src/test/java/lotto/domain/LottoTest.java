package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	@DisplayName("로또 match 테스트")
	@Test
	public void lottoMatchTest() {
		int expected = 3;
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 10, 11, 12), 13);
		MatchResult match = lotto.match(winLotto);
		assertThat(expected).isEqualTo(match.getCount());
	}

	@DisplayName("로또 LottoRank 테스트")
	@Test
	public void lottoRankTest() {
		LottoRank expected = LottoRank.SECOND;
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 12), 6);
		LottoRank actual = lotto.rankLotto(winLotto);
		assertThat(expected).isEqualTo(actual);
	}
}