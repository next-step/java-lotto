package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

	private List<LottoNumber> lottoNumbers;
	private WinningNumber winningNumber;
	private LottoMatchResults results;
	private final int payment = 5000;

	@BeforeEach
	void setUp() {
		lottoNumbers = Arrays.asList(new LottoNumber(Arrays.asList(3, 6, 11, 28, 30, 31)) // 4개 일치
			, new LottoNumber(Arrays.asList(1, 2, 40, 41, 42, 45)) // 0개 일치
			, new LottoNumber(Arrays.asList(1, 2, 40, 41, 42, 44)) // 0개 일치
			, new LottoNumber(Arrays.asList(1, 5, 11, 19, 28, 40)) // 3개 일치
			, new LottoNumber(Arrays.asList(3, 6, 8, 11, 19, 28))); // 6개 일치
		winningNumber = new WinningNumber(new LottoNumber(Arrays.asList(3, 6, 8, 11, 19, 28)), 45);
		results = new LottoMatchResults(payment);
	}

	@Test
	@DisplayName("N개의 로또 횟차에 대한 당첨금액 별, 당첨 횟 수의 합을 구할 수 있어야한다.")
	void winningResultCountTest() {
		LottoNumbers userNumbers = new LottoNumbers(lottoNumbers);
		results = userNumbers.match(results, winningNumber);
		assertThat(results.getResultCount(LottoRank.FIFTH)).isEqualTo(1);
		assertThat(results.getResultCount(LottoRank.FOURTH)).isEqualTo(1);
		assertThat(results.getResultCount(LottoRank.THIRD)).isEqualTo(0);
		assertThat(results.getResultCount(LottoRank.FIRST)).isEqualTo(1);
	}

	@Test
	@DisplayName("N개의 로또 횟차에 대한 총 당첨금액의 합을 알 수 있어야한다.")
	void winningResultPriceTest() {
		LottoNumbers userNumbers = new LottoNumbers(lottoNumbers);
		results = userNumbers.match(results, winningNumber);
		long totalEarnings = LottoRank.FIFTH.getEarnings() + LottoRank.FOURTH.getEarnings() + LottoRank.FIRST
			.getEarnings();
		assertThat(results.getTotalEarnings()).isEqualTo(totalEarnings);
	}

	@Test
	@DisplayName("N개의 로또 횟차에 대한 총 당첨금액과 구매금액을 통해 수익률을 구할 수 있어야한다.")
	void winningResultEarningsRateTest() {
		LottoNumbers userNumbers = new LottoNumbers(lottoNumbers);
		results = userNumbers.match(results, winningNumber);
		long totalEarnings = LottoRank.FIFTH.getEarnings() + LottoRank.FOURTH.getEarnings() + LottoRank.FIRST
			.getEarnings();

		assertThat(results.getEarningRate()).isEqualTo((double) totalEarnings / payment);
	}
}
