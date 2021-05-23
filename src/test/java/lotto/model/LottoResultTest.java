package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

	@Test
	@DisplayName("당첨금 총 합계는 등수별 금액 * 등수별 당첨 횟수 이다.")
	public void sumTotalPrizeTest() {
		LottoResult lottoResult = creatLottoResult(LottoRank.FIRST, LottoRank.THIRD, LottoRank.THIRD);

		assertThat(lottoResult.sumTotalPrize()).isEqualTo(Money.ofWons(2_003_000_000));
	}

	@Test
	@DisplayName("수익률은 당첨금 총합 / 원금 이다.")
	public void calculateEarningRateTest() {
		LottoResult lottoResult = creatLottoResult(LottoRank.FIFTH);

		Rate rate = lottoResult.calculateEarningRate(Money.ofWons(14000));

		assertThat(rate.floor(2)).isEqualTo(Rate.of(0.35));
	}

	private LottoResult creatLottoResult(LottoRank... lottoRanks) {
		LottoResult lottoResult = new LottoResult();
		for (LottoRank lottoRank : lottoRanks) {
			lottoResult.increaseCountOfRank(lottoRank);
		}
		return lottoResult;
	}
}
