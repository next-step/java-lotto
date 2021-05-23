package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

	@DisplayName("로또 번호 객체 비교 테스트")
	@Test
	void equals() {
		// given
		int number = 1;

		// then
		LottoNumber actual = new LottoNumber(number);

		// then
		assertThat(actual).isEqualTo(new LottoNumber(number));
	}

}
