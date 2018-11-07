package lotto.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 07/11/2018.
 */
public class LottoMatchingResultTest {
	@Test
	public void test_총수익률_계산() {
		Map<LottoWinnerType, Long> lottoWinnerTypeListMap = new HashMap<>();
		lottoWinnerTypeListMap.put(LottoWinnerType.FOURTH_WINNER, 1l);
		lottoWinnerTypeListMap.put(LottoWinnerType.LOSING_TICKET, 13l);

		LottoMatchingResult lottoMatchingResult = new LottoMatchingResult(lottoWinnerTypeListMap);

		assertThat(lottoMatchingResult.getTotalPurchaseAmount()).isEqualTo(14_000);
		assertThat(lottoMatchingResult.getTotalProfits()).isEqualTo(5_000);
		assertThat(lottoMatchingResult.getProfitsRate()).isEqualTo(new BigDecimal("0.35"));
	}
}