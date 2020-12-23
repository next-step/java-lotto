package lotto.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Message;
import lotto.domain.Money;

class LottoServiceTest {
	@Test
	@DisplayName("1개도 구매할수 없으면 IllegalArgumentException을 발생한다.")
	void buyMaxLottoLotteries_wrong_money_test() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoService(new Money(900)))
			.withMessage(Message.INVALID_BUY_LOTTO);
	}

	@Test
	@DisplayName("구매 가능한 만큼 로또를 자동으로 생성한다.")
	void buyMaxLottoLotteries_size_test() {
		assertThat(new LottoService(new Money(4000)).getLottoLotteries().getCount())
			.isEqualTo(4);
	}
}