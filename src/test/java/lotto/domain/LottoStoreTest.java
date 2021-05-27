package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

	private final LottoStore lottoStore = new LottoStore();

	@Test
	void buy() {
		// given
		String moneyStr = "10000";
		List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"),
			new LottoNumberText("1,2,3,4,5,6"));
		LottoBuyingRequest lottoBuyingRequest = new LottoBuyingRequest(new Money(moneyStr),
			new ManualLottoNumbers(lottoNumberTextList));

		// when
		UserLotto userLotto = lottoStore.buy(lottoBuyingRequest);

		// then
		assertThat(userLotto).isNotNull();
	}

	@DisplayName("유효성 체크 테스트")
	@Test
	void invalid() {
		// given
		List<LottoNumberText> lottoNumberTextList = Collections.singletonList(new LottoNumberText("1,2,3,4,5,6"));

		// when
		Throwable throwable = catchThrowable(
			() -> lottoStore.buy(new LottoBuyingRequest(new Money("10"), new ManualLottoNumbers(lottoNumberTextList))));

		// then
		assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
	}

}
