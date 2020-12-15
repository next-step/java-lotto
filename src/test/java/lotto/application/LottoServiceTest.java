package lotto.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Message;
import lotto.domain.Money;

class LottoServiceTest {
	@Test
	@DisplayName("1개도 구매할수 없으면 IllegalArgumentException을 발생한다.")
	void buyLottoTest() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoService(new Money(900)).buyLotto())
			.withMessage(Message.INVALID_BUY_LOTTO);
	}
}