package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 10/11/2018.
 */
public class LottoNumberTest {

	@Test
	public void test_객체생성() {
		LottoNumber lottoNumber = LottoNumber.of(10);
		int actual = lottoNumber.getNumber();
		assertThat(actual).isEqualTo(10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_숫자46이상() {
		LottoNumber.of(46);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_숫자0이하() {
		LottoNumber.of(0);
	}

}