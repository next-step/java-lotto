package lotto.domain.util;

import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoPrize;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class EarningsRateCalculatorTest {

	@Test
	void 수익률_계산기는_수익률을_계산할_수_있다() {
		// given
		List<LottoDto> lotteries = Arrays.asList(new LottoDto(LottoPrize.FIRTH), new LottoDto(LottoPrize.LOST));

		// when
		double earningsRatio = EarningsRateCalculator.calculate(lotteries, LottoCreator.LOTTO_PRICE);

		// then
		assertThat(earningsRatio).isEqualTo(2.5);
	}

}
