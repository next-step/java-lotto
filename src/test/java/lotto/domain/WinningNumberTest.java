package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class WinningNumberTest {

	@Test
	public void 당첨번호가_존재할때_검증() {
		WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");

		int number = 3;

		assertThat(winningNumber.hasNumber(number)).isTrue();
	}

	@Test
	public void 당첨번호가_존재하지않을때_검증() {
		WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");

		int number = 9;

		assertThat(winningNumber.hasNumber(number)).isFalse();
	}
}