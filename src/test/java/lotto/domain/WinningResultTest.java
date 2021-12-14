package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
	@Test
	@DisplayName("5등테스트하기")
	void calculateFifth() {
		//given
		WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(LottoNumbers.createManualLottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));

		WinningResult result = new WinningResult(winningNumbers, lottoNumbers);

		//when
		List<LotteryWinnings> calc = result.calculatedLotteryWinnings();

		//then
		for (LotteryWinnings winnings : calc) {
			assertThat(winnings).isEqualTo(new LotteryWinnings(5));
		}

	}

	@Test
	@DisplayName("1~5등 테스트")
	void calculateCase() {
		WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(LottoNumbers.createManualLottoNumber(Arrays.asList(1, 2, 3, 7, 8, 9)));
		lottoNumbers.add(LottoNumbers.createManualLottoNumber(Arrays.asList(1, 2, 3, 4, 8, 9)));
		lottoNumbers.add(LottoNumbers.createManualLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 9)));
		lottoNumbers.add(LottoNumbers.createManualLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));

		WinningResult result = new WinningResult(winningNumbers, lottoNumbers);

		//when
		List<LotteryWinnings> calc = result.calculatedLotteryWinnings();

		//then
		assertThat(calc).isEqualTo(
			Arrays.asList(new LotteryWinnings(5), new LotteryWinnings(4), new LotteryWinnings(3),
				new LotteryWinnings(1)));
	}
}