package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRunnerTest {

	LottoNumbers manualNumbers;

	@BeforeEach
	void setUp() {
		manualNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(Arrays.asList(3, 6, 11, 28, 30, 31)) // 4개 일치
			, new LottoNumber(Arrays.asList(1, 2, 40, 41, 42, 45)) // 0개 일치
			, new LottoNumber(Arrays.asList(1, 2, 40, 41, 42, 44)) // 0개 일치
			, new LottoNumber(Arrays.asList(1, 5, 11, 19, 28, 40)) // 3개 일치
			, new LottoNumber(Arrays.asList(3, 6, 8, 11, 19, 28)))); // 6개 일치);
	}

	@Test
	@DisplayName("(총 금액으로 구입할 수 있는 로또) - (수동 로또 리스트의 사이즈) 만큼 자동 생성해야한다.")
	void autoAmountWithManualTest() {
		LottoRunner runner = new LottoRunner(8000, manualNumbers);
		assertThat(manualNumbers.getLottoNumbersSize()).isEqualTo(5);
		assertThat(runner.autoGenerableAmount(manualNumbers)).isEqualTo(3);
		assertThat(runner.totalLottoNumberAmount()).isEqualTo(8);
	}

	@Test
	@DisplayName("N개의 로또 횟차에 대한 총 당첨금액과 구매금액을 통해 수익률을 구할 수 있어야한다.")
	void winningResultEarningsRateTest() {
		LottoRunner runner = new LottoRunner(3000, manualNumbers);
		WinningNumber winningNumber = new WinningNumber(new LottoNumber(Arrays.asList(3, 6, 8, 11, 19, 28)), 45);
		runner.match(winningNumber);
		long totalEarnings = LottoRank.FIFTH.getEarnings() + LottoRank.FOURTH.getEarnings() + LottoRank.FIRST
			.getEarnings();

		assertThat(runner.getEarningRate()).isEqualTo((double) totalEarnings / 3000);
	}
}
