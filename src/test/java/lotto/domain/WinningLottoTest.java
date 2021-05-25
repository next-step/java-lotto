package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨로또 테스트")
public class WinningLottoTest {

	private WinningLotto winningLotto;

	@BeforeEach
	void setUp() {
		winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 7);
	}

	@Test
	@DisplayName("당첨번호와 비교하여 랭킹을 구하는 테스트")
	void rank() {
		Assertions.assertThat(winningLotto.findRank(new Lotto(1, 2, 3, 4, 5, 6))).isEqualTo(Rank.FIRST); //1등
		Assertions.assertThat(winningLotto.findRank(new Lotto(1, 2, 3, 4, 5, 7))).isEqualTo(Rank.SECOND); //2등 (보너스매치)
		Assertions.assertThat(winningLotto.findRank(new Lotto(1, 2, 3, 4, 5, 10))).isEqualTo(Rank.THIRD); //3등
		Assertions.assertThat(winningLotto.findRank(new Lotto(1, 2, 3, 4, 9, 10))).isEqualTo(Rank.FOURTH); //4등
		Assertions.assertThat(winningLotto.findRank(new Lotto(1, 2, 3, 8, 9, 10))).isEqualTo(Rank.FIFTH); //5등
	}

}
