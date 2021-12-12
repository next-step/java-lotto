package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoNumberTest {
	@Test
	void createLottoNumber() {
		LottoNumber number = new LottoNumber(1);
		assertThat(number.value()).isBetween(1, 45);
	}
}