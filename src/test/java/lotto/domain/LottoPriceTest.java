package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPriceTest {

	@DisplayName("티켓 가격보다 구매 가격이 낮거나, 티켓 가격보다 수동 구매 개수가 높을수 없다.")
	@Test
	void 구매_가격_테스트() {
		assertThatThrownBy(() -> new LottoPrice("700", "0"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("티켓의 가격보다 구매 가격이 낮습니다.");

		assertThatThrownBy(() -> new LottoPrice("10000", "11"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("수동으로 구매 불가능한 개수 입니다.");
	}
}
