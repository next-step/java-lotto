package lotto.domain;

import static com.google.common.primitives.Ints.asList;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.enums.Prize;
import org.junit.Test;

public class WinningNumberTest {

	@Test
	public void 로또_당첨_검증() {
		WinningNumber winningNumber = new WinningNumber("1, 2, 3, 7, 8, 9");
		Lotto lotto = new Lotto(asList(1, 2, 3, 4, 5, 6)); // 3개 매치

		assertThat(winningNumber.match(lotto)).isEqualTo(Prize.MATCH3);
	}
}