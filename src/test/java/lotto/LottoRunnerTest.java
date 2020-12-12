package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRunnerTest {

	private List<LottoNumber> lottoNumbers;
	private WinningNumber winningNumber;

	@BeforeEach
	void setUp() {
		lottoNumbers = Arrays.asList(new LottoNumber(Arrays.asList(3, 6, 11, 28, 30, 31)) // 4개 일치
			, new LottoNumber(Arrays.asList(1, 2, 40, 41, 42, 45)) // 0개 일치
			, new LottoNumber(Arrays.asList(1, 2, 40, 41, 42, 44)) // 0개 일치
			, new LottoNumber(Arrays.asList(1, 5, 11, 19, 28, 40)) // 3개 일치
			, new LottoNumber(Arrays.asList(3, 6, 8, 11, 19, 28))); // 6개 일치
		winningNumber = new WinningNumber(Arrays.asList(3, 6, 8, 11, 19, 28));
	}

	@Test
	@DisplayName("N,000원의 금액을 입력받으면, N개의 로또 숫자(6개)를 생성해야한다.")
	void createLottoNumbersByMoneyTest() {
		LottoRunner runner = new LottoRunner(5000);
		assertThat(runner.getLottoNumbersSize()).isEqualTo(5);
	}

	@Test
	@DisplayName("N개의 로또 횟차에 대한 당첨금액 별, 당첨 횟 수의 합을 구할 수 있어야한다.")
	void winningResultCountTest() {
		LottoRunner runner = new LottoRunner(lottoNumbers);
		LottoResults results = runner.run(winningNumber);
		assertThat(results.getResultCount(LottoRank.FOURTH)).isEqualTo(1);
		assertThat(results.getResultCount(LottoRank.THIRD)).isEqualTo(1);
		assertThat(results.getResultCount(LottoRank.SECOND)).isEqualTo(0);
		assertThat(results.getResultCount(LottoRank.FIRST)).isEqualTo(1);
	}

	@Test
	@DisplayName("N개의 로또 횟차에 대한 총 당첨금액의 합을 알 수 있어야한다.")
	void winningResultPriceTest() {
		LottoRunner runner = new LottoRunner(lottoNumbers);
		LottoResults results = runner.run(winningNumber);
		long totalEarnings = LottoRank.FOURTH.getEarnings() + LottoRank.THIRD.getEarnings() + LottoRank.FIRST.getEarnings();
		assertThat(results.getTotalEarnings()).isEqualTo(totalEarnings);
	}

	@Test
	@DisplayName("N개의 로또 횟차에 대한 총 당첨금액과 구매금액을 통해 수익률을 구할 수 있어야한다.")
	void winningResultEarningsRateTest() {
		LottoRunner runner = new LottoRunner(lottoNumbers);
		LottoResults results = runner.run(winningNumber);
		long totalEarnings = LottoRank.FOURTH.getEarnings() + LottoRank.THIRD.getEarnings() + LottoRank.FIRST.getEarnings();
		int payment = 5000;

		assertThat(results.getEarningRate(payment)).isEqualTo((double) totalEarnings / payment);
	}
}
