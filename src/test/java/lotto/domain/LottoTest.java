package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.utils.LottoNumberGenerator;
import org.junit.Test;

public class LottoTest {

	@Test
	public void 당첨번호가_존재할때_검증() {
		Lotto lotto = new Lotto(LottoNumberGenerator.parse("1,2,3,4,5,6"));

		LottoNumber number = new LottoNumber(3);

		assertThat(lotto.hasNumber(number)).isTrue();
	}

	@Test
	public void 당첨번호가_존재하지않을때_검증() {
		Lotto lotto = new Lotto(LottoNumberGenerator.parse("1,2,3,4,5,6"));

		LottoNumber number = new LottoNumber(9);

		assertThat(lotto.hasNumber(number)).isFalse();
	}

	@Test
	public void 로또_당첨_검증() {
		Lotto lotto = new Lotto(LottoNumberGenerator.parse("1,2,3,4,5,6"));
		Lotto winningNumber = new Lotto(LottoNumberGenerator.parse("1,2,3,7,8,9"));

		assertThat(lotto.match(winningNumber)).isEqualTo(3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 중복된_번호_오류_검증() {
		new Lotto(LottoNumberGenerator.parse("1, 1, 1, 42, 33, 6"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void 잘못된_번호_개수_오류_검증() {
		new Lotto(LottoNumberGenerator.parse("1"));
	}
}