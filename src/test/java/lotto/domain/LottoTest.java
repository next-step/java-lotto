package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	public void lottoMatchTest() {
		int expected = 3;
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
		int actual = lotto.match(winLotto);
		assertThat(expected).isEqualTo(actual);
	}

	@Test
	public void lottoNullTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(null));
	}

	@Test
	public void lottoOtherNumberTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(-100, 1, 2, 3, 4, 5)));
		assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1000, 1, 2, 3, 4, 5)));
	}

	@Test
	public void lottoRankTest() {
		LottoRank expected = LottoRank.FOURTH;
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
		LottoRank actual = lotto.rankLotto(winLotto);
		assertThat(expected).isEqualTo(actual);
	}
}