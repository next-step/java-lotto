package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoNumbersTest {
	LottoNumbers lottoNumbers = new LottoNumbers();

	@Test
	public void generateLottoNumbersTest() {
		int expected = 6;
		int actual = lottoNumbers.generateLottoNumbers(6, new LottoNumberGenerator()).size();
		assertThat(expected).isEqualTo(actual);
	}
}