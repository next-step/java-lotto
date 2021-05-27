package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

	@Test
	@DisplayName("보너스 번호가 이미 로또번호에 존재하면 익셉션을 발생한다")
	void duplicationNotAllowedTest() {
		List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
		int bonusNumber = 7;
		assertThatThrownBy(() -> WinningNumber.of(lottoNumbers, bonusNumber))
				.isInstanceOf(RuntimeException.class);
	}
}
