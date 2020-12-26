package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
	@Test
	@DisplayName("1개도 구매할수 없으면 IllegalArgumentException을 발생한다.")
	void buyMax_IllegalArgumentException_test() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Money(900).buyMax(LottoLottery.LOTTO_PRICE_PER_PIECE))
			.withMessage(String.format(Message.INVALID_BUY_LOTTO, LottoLottery.LOTTO_PRICE_PER_PIECE));

	}

	@Test
	@DisplayName("입력 받은 가격으로 최대로 구매한 갯수를 반환한다.")
	void buyMaxTest() {
		assertThat(new Money(14000).buyMax(LottoLottery.LOTTO_PRICE_PER_PIECE)).isEqualTo(14);
	}
}