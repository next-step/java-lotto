package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class WinningLottoTest {
	@Test
	@DisplayName("당첨번호와 내 로또를 비교하여 등수를 낸다")
	void 당첨번호와_내로또를_비교하여_등수를_낸다() {
		WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7));
		Lotto lotto = new Lotto(1, 2, 3, 4, 5, 7);

		assertThat(winningLotto.calculateRank(lotto)).isEqualTo(Rank.RANK2);
	}
}
