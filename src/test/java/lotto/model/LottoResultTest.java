package lotto.model;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoResultTest {

	@Test
	@DisplayName("당첨금 총 합계는 등수별 금액 * 등수별 당첨 횟수 이다.")
	public void sumTotalPrizeTest() {
		LottoResult lottoResult = LottoResult.of(asList(LottoRank.FIRST, LottoRank.THIRD, LottoRank.THIRD));

		assertThat(lottoResult.sumTotalPrize()).isEqualTo(Money.ofWons(2_003_000_000));
	}

	@Test
	@DisplayName("수익률은 당첨금 총합 / 원금 이다.")
	public void calculateEarningRateTest() {
		LottoResult lottoResult = LottoResult.of(asList(LottoRank.FIFTH));

		Rate rate = lottoResult.calculateEarningRate(Money.ofWons(14000));

		assertThat(rate.floor(2)).isEqualTo(Rate.of(0.35));
	}

	@ParameterizedTest
	@DisplayName("등수 별로 몇번 당첨됐는지 정확하게 나와야 한다.")
	@CsvSource(value = {"FIRST:2", "SECOND:1", "THIRD:1", "FOURTH:2", "FIFTH:0"}, delimiter = ':')
	public void createTest(LottoRank rank, int expectedCount) {
		LottoResult result = LottoResult.of(asList(LottoRank.FIRST, LottoRank.FIRST, LottoRank.SECOND,
			LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FOURTH));

		assertThat(result.count(rank)).isEqualTo(expectedCount);
	}
}
