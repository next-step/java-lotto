package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WinningNumberTest {

	private List<Integer> winningNumbers = Arrays.asList(3, 6, 8, 11, 19, 28);

	@Test
	void matchThreeNumberTest() {
		WinningNumber winNumber = new WinningNumber(winningNumbers);
		assertThat(winNumber.match(Arrays.asList(4, 6, 11, 19, 39, 42))).isEqualTo(3);
	}

	@Test
	void matchFourNumberTest() {
		WinningNumber winNumber = new WinningNumber(winningNumbers);
		assertThat(winNumber.match(Arrays.asList(6, 8, 11, 19, 39, 42))).isEqualTo(4);
	}

	@Test
	void matchFiveNumberTest() {
		WinningNumber winNumber = new WinningNumber(winningNumbers);
		assertThat(winNumber.match(Arrays.asList(3, 6, 11, 19, 28, 42))).isEqualTo(5);
	}

	@Test
	void matchSixNumberTest() {
		WinningNumber winNumber = new WinningNumber(winningNumbers);
		assertThat(winNumber.match(Arrays.asList(3, 6, 8, 11, 19, 28))).isEqualTo(6);
	}
}
