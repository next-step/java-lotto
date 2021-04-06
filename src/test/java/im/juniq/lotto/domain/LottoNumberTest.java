package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTest {
	@Test
	void create() {
		assertThatCode(() -> new LottoNumber(1)).doesNotThrowAnyException();
		assertThatCode(() -> new LottoNumber(45)).doesNotThrowAnyException();
	}

	@Test
	void checkNumber() {
		assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
	}
}
