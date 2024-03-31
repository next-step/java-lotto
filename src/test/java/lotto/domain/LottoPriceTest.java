package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoPriceTest {
	@Test
	void 천원_이상의_금액을_입력하지_않으면_오류발생() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new LottoPrice(0))
				.withMessageMatching("1000원 이상의 금액을 입력해야 합니다.");
	}
}
