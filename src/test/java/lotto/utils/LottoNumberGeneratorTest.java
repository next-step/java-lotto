package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.Test;

public class LottoNumberGeneratorTest {

	@Test
	public void 자동으로_구매한_로또_확인() {
		assertThat(LottoNumberGenerator.pick()).hasSize(Lotto.NUMBER_COUNT);
	}

	@Test
	public void 수동으로_구매한_로또_검증() {
		final Integer number1 = 10, number2 = 2, number3 = 13, number4 = 42, number5 = 33, number6 = 6;
		String numbers = String.join(", ",
				String.valueOf(number1), String.valueOf(number2), String.valueOf(number3),
				String.valueOf(number4), String.valueOf(number5), String.valueOf(number6));

		assertThat(LottoNumberGenerator.parse(numbers))
				.hasSize(Lotto.NUMBER_COUNT)
				.containsExactly(
						new LottoNumber(number1), new LottoNumber(number2), new LottoNumber(number3),
						new LottoNumber(number4), new LottoNumber(number5), new LottoNumber(number6));
	}
}