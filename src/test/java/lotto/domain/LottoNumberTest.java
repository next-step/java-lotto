package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoNumberTest {

	@Test
	public void 올바른_번호_유효성체크_검증() {
		Integer number = 4;

		assertThat(new LottoNumber(number)).isNotNull();
	}

	@Test(expected = IllegalArgumentException.class)
	public void 잘못된_번호_유효성체크_검증() {
		Integer number = LottoNumber.MAX_NUMBER + 1;

		new LottoNumber(number);
	}
}