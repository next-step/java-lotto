package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
	@Test
	@DisplayName("로또 리워드를 갖는 로또를 생성한다.")
	public void winningLottoTest() {
		Lotto lotto = new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
		Lotto lastWinningLotto = new Lotto(new HashSet<>(Arrays.asList(1,2,3,14,15,16)));
		WinningLotto winningLotto = new WinningLotto(lotto, lastWinningLotto);
		assertThat(winningLotto.getLottoReward()).isEqualTo(LottoReward.FOURTH);
	}
}
