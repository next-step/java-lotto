package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	public void createNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(5);
		assertThat(lottoNumber.toString()).isEqualTo("5");
	}

	@Test
	public void equalsNumberTest() {
		LottoNumber sourceLottoNumber = new LottoNumber(5);
		LottoNumber expectedLottoNumber = new LottoNumber(5);
		assertThat(sourceLottoNumber.equals(expectedLottoNumber)).isEqualTo(true);
	}

	@Test
	public void notEqualsNumberTest() {
		LottoNumber sourceLottoNumber = new LottoNumber(5);
		LottoNumber expectedLottoNumber = new LottoNumber(3);
		assertThat(sourceLottoNumber.equals(expectedLottoNumber)).isEqualTo(false);
	}

}
