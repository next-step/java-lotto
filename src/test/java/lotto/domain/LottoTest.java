package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.enums.Prize;
import org.junit.Test;

public class LottoTest {

	@Test
	public void 로또_당첨_검증() {
		Lotto lotto = new Lotto(asList(1, 2, 3, 4, 5, 6)); // 3개 매치
		WinningNumber winningNumber = new WinningNumber("1, 2, 3, 7, 8, 9");

		assertThat(lotto.match(winningNumber)).isEqualTo(Prize.MATCH3);
	}
}