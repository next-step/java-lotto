package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {

	@Test
	void 생성자() {
		assertThat(new WinningNumbers(new int[] {1,2,3,4,5,6})
		.getWinningNumbers()).contains(1,2,3,4,5,6);
	}
}