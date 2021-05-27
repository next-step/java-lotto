package lotto;

import lotto.domain.LottoBuyingRequest;
import lotto.domain.LottoNumberText;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.Money;
import lotto.domain.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoControllerTest {

	@DisplayName("로또 구매 테스트")
	@Test
	void buyLotto() {
		// given
		LottoController lottoController = new LottoController();
		String moneyStr = "10000";
		List<LottoNumberText> numberStrings = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"), new LottoNumberText("1,2,3,4,5,6"));
		ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers(numberStrings);
		LottoBuyingRequest lottoBuyingRequest = new LottoBuyingRequest(new Money(moneyStr), manualLottoNumbers);

		// when
		UserLotto userLotto = lottoController.buyLotto(lottoBuyingRequest);

		// then
		assertThat(userLotto).isNotNull();
	}
}
