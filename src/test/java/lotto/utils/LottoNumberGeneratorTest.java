package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoNumberGeneratorTest {

	private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

	@Test
	public void 자동으로_구매한_로또_확인() {
		assertThat(lottoNumberGenerator.pick()).hasSize(LottoNumberGenerator.PICK_COUNT);
	}

	@Test
	public void 수동으로_구매한_로또_검증() {
		final int number1 = 10, number2 = 2, number3 = 13, number4 = 42, number5 = 33, number6 = 6;
		String numbers = String.join(", ",
				String.valueOf(number1), String.valueOf(number2), String.valueOf(number3),
				String.valueOf(number4), String.valueOf(number5), String.valueOf(number6));

		assertThat(lottoNumberGenerator.pick(numbers))
				.hasSize(LottoNumberGenerator.PICK_COUNT)
				.containsExactly(number1, number2, number3, number4, number5, number6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 수동구매_중복된_번호_오류_검증() {
		// 중복된 숫자 3개 입력
		final int number1 = 1, number2 = 1, number3 = 1, number4 = 42, number5 = 33, number6 = 6;
		String numbers = String.join(", ",
				String.valueOf(number1), String.valueOf(number2), String.valueOf(number3),
				String.valueOf(number4), String.valueOf(number5), String.valueOf(number6));

		lottoNumberGenerator.pick(numbers);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 수동구매_잘못된_범위의_번호_오류_검증() {
		// 중복된 숫자 3개 입력
		final int wrongNumber = 49, number2 = 1, number3 = 1, number4 = 42, number5 = 33, number6 = 6;
		String numbers = String.join(", ",
				String.valueOf(wrongNumber), String.valueOf(number2), String.valueOf(number3),
				String.valueOf(number4), String.valueOf(number5), String.valueOf(number6));

		lottoNumberGenerator.pick(numbers);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 수동구매_잘못된_번호_개수_오류_검증() {
		// 중복된 숫자 3개 입력
		final int number1 = 1;
		String numbers = String.join(", ", String.valueOf(number1));

		lottoNumberGenerator.pick(numbers);
	}
}