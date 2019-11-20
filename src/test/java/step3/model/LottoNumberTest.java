package step3.model;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
	@Test
	void equals() {
		assertThat(LottoNumber.of(3)).isEqualTo(LottoNumber.of(3));
	}

	@Test
	void 문자_숫자_생성비교() {
		assertThat(LottoNumber.of(7)).isEqualTo(LottoNumber.of("7 "));
	}

	@Test
	void checkMinNumber() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			LottoNumber.of(-1);
		});
	}

	@Test
	void checkMaxNumber() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			LottoNumber.of(46);
		});
	}
}
