package lotto.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoTest {

	@Test
	public void 당첨번호가_존재할때_검증() {
		Lotto lotto = new Lotto(asList(1, 2, 3, 4, 5, 6));

		int winningNumber = 3;

		assertThat(lotto.match(winningNumber)).isTrue();
	}

	@Test
	public void 당첨번호가_존재하지않을때_검증() {
		Lotto lotto = new Lotto(asList(1, 2, 3, 4, 5, 6));

		int winningNumber = 9;

		assertThat(lotto.match(winningNumber)).isFalse();
	}
}