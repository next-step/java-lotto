package step2;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoNumbers;
import step2.domain.LottoPrice;
import step2.domain.LottoProfit;
import step2.domain.LottoResults;
import step2.domain.LottoWin;
import step2.domain.Lottos;

public class LottoProfitTest {

	@DisplayName("수익률 - 5장 구매하여 6개 일치, 3개 일치시 수익률 테스트")
	@Test
	void given_lottos_when_result_profit_then_greater_than_expected_profit() {
		final int purchasePrice = 5000;
		final LottoNumbers winNumbers = new LottoNumbers(1,2,3,4,5,6);
		final LottoNumber bonusNumber = new LottoNumber(12);
		Lotto lotto1 = new Lotto(new LottoNumbers(1,2,3,4,5,6));
		Lotto lotto2 = new Lotto(new LottoNumbers(1,2,3,7,8,9));
		Lotto lotto3 = new Lotto(new LottoNumbers(1,2,40,41,42,43));
		Lotto lotto4 = new Lotto(new LottoNumbers(1,2,40,41,42,43));
		Lotto lotto5 = new Lotto(new LottoNumbers(1,2,40,41,42,43));
		Lottos lottos = new Lottos(lotto1, lotto2, lotto3, lotto4, lotto5);
		LottoResults lottoResults = new LottoResults(lottos, winNumbers, bonusNumber);

		LottoProfit lottoProfit = new LottoProfit(new LottoPrice(purchasePrice), lottoResults);

		Double expected = BigDecimal.valueOf(LottoWin.MATCH_6.getPrice() + LottoWin.MATCH_3.getPrice())
			.divide(BigDecimal.valueOf(purchasePrice), 2, BigDecimal.ROUND_HALF_UP)
			.doubleValue();

		assertThat(lottoProfit.getProfitRatio()).isEqualTo(expected);
	}

}
