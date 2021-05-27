package lotto;

import static lotto.LottoView.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoViewTest {

	private final LottoView lottoView = new LottoView();

	@DisplayName("로또 구입 금액 입력 요청 테스트")
	@Test
	void inputMoneyView() {
		//when
		String message = lottoView.inputMoneyView();

		// then
		assertThat(message).isEqualTo(LottoView.INPUT_MONEY_MESSAGE);
	}

	@DisplayName("로또 구매 개수 출력 테스트")
	@Test
	void userLottoCountView() {
		// when
		String message = lottoView.userLottoCountView(1);

		// then
		assertThat(message).isEqualTo(String.format(LOTTO_TICKET_COUNT_FORMAT, 1));
	}

	@DisplayName("당첨 번호 입력 요청 테스트")
	@Test
	void inputWinningLottoNumbers() {
		// when
		String message = lottoView.inputWinningLottoNumbers();

		// then
		assertThat(message).isEqualTo(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
	}

}
