package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPriceTest {

	@DisplayName("티켓 가격보다 구매 가격이 낮을수 없다")
	@Test
	void 구매_가격_테스트() {
		LottoPrice lottoPrice = new LottoPrice("700");
		assertThatThrownBy(() -> lottoPrice.purchaseTicketAmount())
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("티켓의 가격보다 구매 가격이 낮습니다.");
	}
}
