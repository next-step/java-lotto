package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	WinLotto winLotto = new WinLotto(new Lotto(new ArrayList<>(Arrays.asList(
		new LottoNumber(1),
		new LottoNumber(2),
		new LottoNumber(3),
		new LottoNumber(4),
		new LottoNumber(5),
		new LottoNumber(6)
	))), new LottoNumber(7));

	@DisplayName("로또 5개만 구성하는 경우 테스트")
	@Test
	public void lottoLengthTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(new ArrayList<>(Arrays.asList(
			new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(10),
			new LottoNumber(11)
		))));
	}

	@DisplayName("로또 match 테스트")
	@Test
	public void lottoMatchTest() {
		int expected = 3;
		Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(
			new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(8),
			new LottoNumber(9),
			new LottoNumber(10)
		)));
		MatchResult match = lotto.match(winLotto);
		assertThat(expected).isEqualTo(match.getCount());
	}

	@DisplayName("로또 LottoRank 테스트")
	@Test
	public void lottoRankTest() {
		LottoRank expected = LottoRank.SECOND;
		Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(
			new LottoNumber(1),
			new LottoNumber(2),
			new LottoNumber(3),
			new LottoNumber(4),
			new LottoNumber(5),
			new LottoNumber(7)
		)));
		LottoRank actual = lotto.rankLotto(winLotto);
		assertThat(expected).isEqualTo(actual);
	}
}