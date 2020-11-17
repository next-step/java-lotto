package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
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

	@Test
	@DisplayName("지난주 로또당첨 번호는 6개여야 한다.")
	public void lastLottoWrongTest() {
		Lotto lotto = new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
		Lotto lastWeekLotto = new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5)));
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningLotto(lotto, lastWeekLotto))
				.withMessage("로또 번호는 6개여야 합니다.");
	}

	@Test
	@DisplayName("로또번호는 1~45 사이의 숫자여야 한다.")
	public void lastLottoWrongNumberTest() {
		Lotto lotto = new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
		Lotto lastWeekLotto = new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,100)));
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningLotto(lotto, lastWeekLotto))
				.withMessage("로또는 1~45의 숫자여야 합니다.");
	}
}
