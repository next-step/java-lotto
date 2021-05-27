package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LottoBuyingRequestTest {

	@Test
	void invalid() {
		// given
		String moneyStr = "1000";

		// when
		Throwable throwable = catchThrowable(() -> {
			List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"),
				new LottoNumberText("1,2,3,4,5,6"));
			new LottoBuyingRequest(new Money(moneyStr), new ManualLottoNumbers(lottoNumberTextList));
		});

		// then
		assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void autoLottoCount() {
		// given
		String moneyStr = "10000";
		List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"),
			new LottoNumberText("1,2,3,4,5,6"));

		// when
		LottoBuyingRequest lottoBuyingRequest = new LottoBuyingRequest(new Money(moneyStr),
			new ManualLottoNumbers(lottoNumberTextList));

		// then
		assertThat(lottoBuyingRequest.autoLottoCount()).isEqualTo(8);
	}

	@Test
	void manualLottoCount() {
		// given
		String moneyStr = "10000";
		List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"),
			new LottoNumberText("1,2,3,4,5,6"));

		// when
		LottoBuyingRequest lottoBuyingRequest = new LottoBuyingRequest(new Money(moneyStr),
			new ManualLottoNumbers(lottoNumberTextList));

		// then
		assertThat(lottoBuyingRequest.manualLottoCount()).isEqualTo(2);
	}

	@Test
	void lottoNumberStrings() {
		// given
		String moneyStr = "10000";
		String[] numberArray = new String[] {"1,2,3,4,5,6", "1,2,3,4,5,6"};
		List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"),
			new LottoNumberText("1,2,3,4,5,6"));

		// when
		LottoBuyingRequest lottoBuyingRequest = new LottoBuyingRequest(new Money(moneyStr),
			new ManualLottoNumbers(lottoNumberTextList));

		// then
		assertThat(lottoBuyingRequest.manualLottoNumberStrings()).containsExactly(numberArray);
	}

	@Test
	void hasAutoLottoRequest() {
		// given
		String moneyStr = "10000";
		List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"),
			new LottoNumberText("1,2,3,4,5,6"));

		// when
		LottoBuyingRequest lottoBuyingRequest = new LottoBuyingRequest(new Money(moneyStr),
			new ManualLottoNumbers(lottoNumberTextList));

		// then
		assertThat(lottoBuyingRequest.hasAutoLottoRequest()).isTrue();
	}
}
