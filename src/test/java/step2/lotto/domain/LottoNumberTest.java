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
}
