package lotto;

import static lotto.LottoView.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoBuyingRequest;
import lotto.domain.LottoNumberText;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.Money;

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
		List<LottoNumberText> lottoNumberTextList = Collections.singletonList(new LottoNumberText("1,2,3,4,5,6"));
		String message = lottoView.userLottoCountView(
			new LottoBuyingRequest(new Money("3000"), new ManualLottoNumbers(lottoNumberTextList)));

		// then
		assertThat(message).isEqualTo(String.format(LOTTO_TICKET_COUNT_FORMAT, 1, 2));
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
