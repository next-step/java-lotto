package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoNumberTest {

	@Test
	public void 올바른_번호_유효성체크_검증() {
		Integer number = 4;

		assertThat(LottoNumber.valueOf(number)).isNotNull();
	}

	@Test(expected = IllegalArgumentException.class)
	public void 잘못된_번호_유효성체크_검증1() {
		Integer number = LottoNumber.MIN_NUMBER - 1;

		LottoNumber.valueOf(number);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 잘못된_번호_유효성체크_검증2() {
		Integer number = LottoNumber.MAX_NUMBER + 1;

		LottoNumber.valueOf(number);
	}

	@Test
	public void 동일_클래스_반환_검증() {
		LottoNumber lottoNumber1 = LottoNumber.valueOf(45);
		LottoNumber lottoNumber2 = LottoNumber.valueOf("45");

		assertThat(lottoNumber1).isEqualTo(lottoNumber2);
		assertThat(lottoNumber1 == lottoNumber2).isTrue();
	}
}