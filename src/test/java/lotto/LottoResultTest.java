package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
	@Test
	@DisplayName("로또 당첨 수익률을 반환한다")
	void profitRateTest() {
		LottoResult lottoResult = LottoResult.of(Arrays.asList(
				LottoPrizeType.FIFTH,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS,
				LottoPrizeType.MISS));

		float profitRate = lottoResult.getProfitRate();
		assertThat(profitRate).isEqualTo(0.35f);
	}
}
