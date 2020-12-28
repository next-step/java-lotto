package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	WinLotto winLotto = new WinLotto(new Lotto(new ArrayList<>(Arrays.asList(
		LottoNumber.of(1),
		LottoNumber.of(2),
		LottoNumber.of(3),
		LottoNumber.of(4),
		LottoNumber.of(5),
		LottoNumber.of(6)
	))), LottoNumber.of(7));

	@DisplayName("로또 5개만 구성하는 경우 테스트")
	@Test
	public void lottoLengthTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(new ArrayList<>(Arrays.asList(
			LottoNumber.of(1),
			LottoNumber.of(2),
			LottoNumber.of(3),
			LottoNumber.of(10),
			LottoNumber.of(11)
		))));
	}

	@DisplayName("로또 match 테스트")
	@Test
	public void lottoMatchTest() {
		int expected = 3;
		Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(
			LottoNumber.of(1),
			LottoNumber.of(2),
			LottoNumber.of(3),
			LottoNumber.of(8),
			LottoNumber.of(9),
			LottoNumber.of(10)
		)));
		MatchResult match = lotto.match(winLotto);
		assertThat(expected).isEqualTo(match.getCount());
	}

	@DisplayName("로또 LottoRank 테스트")
	@Test
	public void lottoRankTest() {
		LottoRank expected = LottoRank.SECOND;
		Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(
			LottoNumber.of(1),
			LottoNumber.of(2),
			LottoNumber.of(3),
			LottoNumber.of(4),
			LottoNumber.of(5),
			LottoNumber.of(7)
		)));
		LottoRank actual = lotto.rankLotto(winLotto);
		assertThat(expected).isEqualTo(actual);
	}
}