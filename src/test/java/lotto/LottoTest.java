package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
	@Test
	void checkWinningTest() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
		List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
		int matchedNumber = lotto.checkWinning(winningNumber);
		assertThat(matchedNumber).isEqualTo(5);
	}
}
