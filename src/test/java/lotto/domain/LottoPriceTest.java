package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoPriceTest {
	@Test
	void 천원_이상의_금액을_입력하지_않으면_오류발생() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new LottoPrice(0))
				.withMessageMatching("1000원 이상의 금액을 입력해야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 3, 10})
	@DisplayName("자동 로또 개수 = 금액 / 1000 - 수동 로또 개수")
	void 자동_로또_개수_검증(int number) {
		assertThat(new LottoPrice(10000, number).getNumberOfAutoLotto()).isEqualTo(10000 / 1000 - number);
	}

	@ParameterizedTest
	@ValueSource(ints = {10000, 3000, 1000})
	void 수동_로또는_총_생성_개수를_넘을_수_없다(int price) {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new LottoPrice(price, price / 1000 + 1))
				.withMessageMatching("수동 로또는 " + price / 1000 + "장 까지만 구매할 수 있습니다.");
	}
}
