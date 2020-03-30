package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNoTest {

	@Test
	void isEqualTest() {
		assertThat(LottoNo.getInstance(1))
				.isEqualTo(LottoNo.getInstance(1));
	}

	@Test
	@DisplayName("객체 생성 유효성 테스트")
	void expectConstructorException() {
		assertThatThrownBy(() -> LottoNo.getInstance(0))
				.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> LottoNo.getInstance(46))
				.isInstanceOf(RuntimeException.class);
	}
}