package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.UserLotto;

class LottoControllerTest {

	@DisplayName("로또 구매 테스트")
	@Test
	void buyLotto() {
		// given
		LottoController lottoController = new LottoController();

		// when
		UserLotto userLotto = lottoController.buyLotto("1000");

		// then
		assertThat(userLotto).isNotNull();
	}

}
