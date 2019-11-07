package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LottoPrizesTest {

	@Test
	void LottoPrizes_는_수익률을_계산할_수_있다() {
		// given
		LottoPrizes lottoPrizes = new LottoPrizes(Arrays.asList(LottoPrize.FIRTH, LottoPrize.LOST));

		// when
		double earningsRatio = lottoPrizes.calculateEarningsRatio(LottoCreator.LOTTO_PRICE);

		// then
		assertThat(earningsRatio).isEqualTo(2.5);
	}

}
