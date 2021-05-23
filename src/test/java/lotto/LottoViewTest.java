package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoViewTest {

	@Test
	void inputMoneyView() {
		// given
		LottoView lottoView = new LottoView();

		//when
		String message = lottoView.inputMoneyView();

		// then
		assertThat(message).isEqualTo(LottoView.INPUT_MONEY_MESSAGE);
	}

}
