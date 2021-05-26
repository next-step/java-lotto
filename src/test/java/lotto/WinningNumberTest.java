package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {
	@Test
	@DisplayName("5개의 로또 번호가 일치하고 보너스번호가 일치하면 2등이다")
	void secondPrizeTest() {
		List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
		List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		WinningNumber winningNumber = WinningNumber.of(winningNumbers, bonusNumber);
		LottoPrizeType prizeType = winningNumber.checkWinning(lottoNumbers);
		assertThat(prizeType).isEqualTo(LottoPrizeType.SECOND);
	}
}