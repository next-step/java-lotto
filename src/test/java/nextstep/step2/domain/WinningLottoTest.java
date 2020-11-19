package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningLottoTest {
	@Test
	@DisplayName("로또 리워드를 갖는 로또를 생성한다.")
	public void winningLottoTest() {
		WinningLotto winningLotto = getWinningLotto();
		assertThat(winningLotto.getLottoReward()).isEqualTo(LottoReward.FIFTH);
	}

	@Test
	@DisplayName("지난주 로또당첨 번호는 6개여야 한다.")
	public void lastLottoWrongTest() {
		Lotto lotto = MockLotto.mockLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lastWeekLotto = MockLotto.mockLotto(Arrays.asList(1, 2, 3, 4, 5));
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningLotto(lotto, lastWeekLotto, new LottoNumber(7)))
				.withMessage("로또 번호는 6개여야 합니다.");
	}

	@Test
	@DisplayName("로또번호는 1~45 사이의 숫자여야 한다.")
	public void lastLottoWrongNumberTest() {
		Lotto lotto = MockLotto.mockLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningLotto(lotto, MockLotto.mockLotto(Arrays.asList(1, 2, 3, 4, 5, 100)), new LottoNumber(7)))
				.withMessage("로또는 1~45의 숫자여야 합니다.");
	}

	@Test
	@DisplayName("로또 보너스 번호를 가지고 있는지 테스트")
	public void hasBonusNumberTest() {
		Lotto lotto = MockLotto.mockLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertTrue(getWinningLotto().hasBonusNumber(lotto, new LottoNumber(6)));
		assertFalse(getWinningLotto().hasBonusNumber(lotto, new LottoNumber(7)));
	}

	private WinningLotto getWinningLotto() {
		Lotto lotto = MockLotto.mockLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lastWinningLotto = MockLotto.mockLotto(Arrays.asList(1, 2, 3, 14, 15, 16));
		return new WinningLotto(lotto, lastWinningLotto, new LottoNumber(7));
	}
}
