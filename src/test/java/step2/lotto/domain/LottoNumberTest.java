package step2.lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {
	@Test
	void 생성() {
		LottoNumber lottoNumber = LottoNumber.from(0);

		assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
	}

	@Test
	void 음수는_사용할수_없다() {
		assertThatThrownBy(() -> LottoNumber.from(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 번호는_범위를_넘를_수_없다() {
		int maxNumber = LottoNumber.LOTTO_NUMBER_MAX;

		assertThatThrownBy(() -> LottoNumber.from(maxNumber + 1))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
