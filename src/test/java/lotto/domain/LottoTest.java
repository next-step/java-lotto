package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.enums.Prize;
import org.junit.Test;

public class LottoTest {

	@Test
	public void 당첨번호가_존재할때_검증() {
		Lotto lotto = new Lotto(asList(1, 2, 3, 4, 5, 6)); // 3개 매치

		int number = 3;

		assertThat(lotto.hasNumber(number)).isTrue();
	}

	@Test
	public void 당첨번호가_존재하지않을때_검증() {
		Lotto lotto = new Lotto(asList(1, 2, 3, 4, 5, 6)); // 3개 매치

		int number = 9;

		assertThat(lotto.hasNumber(number)).isFalse();
	}

	@Test
	public void 로또_당첨_검증() {
		Lotto lotto = new Lotto(asList(1, 2, 3, 4, 5, 6)); // 3개 매치
		Lotto winningNumber = new Lotto(asList(1, 2, 3, 7, 8, 9));

		assertThat(lotto.match(winningNumber)).isEqualTo(Prize.MATCH3);
	}
}