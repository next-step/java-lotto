package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.enums.Prize;
import org.junit.Test;

public class WinningLottoTest {

	@Test
	public void 로또_2등_당첨_검증() {
		Lotto lotto = new Lotto(asList(1, 2, 3, 4, 5, 7));
		List<Integer> numbers = asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);

		assertThat(winningLotto.getPrize(lotto)).isEqualTo(Prize.SECOND);
	}
}