package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.enums.Prize;
import org.junit.Test;

public class WinningLottoTest {

	@Test
	public void 로또_2등_당첨_검증() {
		Lotto lotto = new Lotto(asList(1, 2, 3, 4, 5, 7));
		Lotto winningNumber = new Lotto(asList(1, 2, 3, 4, 5, 6));
		int bonusNumber = 7;
		WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

		assertThat(winningLotto.getPrize(lotto)).isEqualTo(Prize.SECOND);
	}
}