package lotto;

import static lotto.OutputView.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoBuyingRequest;
import lotto.domain.LottoNumberText;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.Money;

class OutputViewTest {

	private final UserInterface userInterface = new Console();
	private final OutputView outputView = new OutputView(userInterface);

	@DisplayName("로또 구매 개수 출력 테스트")
	@Test
	void userLottoCountView() {
		// when
		List<LottoNumberText> lottoNumberTextList = Collections.singletonList(new LottoNumberText("1,2,3,4,5,6"));
		String message = outputView.userLottoCountMessage(
			new LottoBuyingRequest(new Money("3000"), new ManualLottoNumbers(lottoNumberTextList)));

		// then
		assertThat(message).isEqualTo(String.format(LOTTO_TICKET_COUNT_FORMAT, 1, 2));
	}

}
