package lotto;

import org.junit.jupiter.api.Test;

import lotto.factory.ManualLottoNumbersFactory;

public class LottoPurchaseArgumentTest {

	@Test
	public void createLottoPurchaseArgumentTest() {
		LottoPayAmounts payAmounts = LottoPayAmounts.of("5000");
		LottoNumbers manualLottoNumbers = ManualLottoNumbersFactory.create("1,2,3,4,5,6");
		LottoPurchaseArgument argument = LottoPurchaseArgument.of(payAmounts, manualLottoNumbers);
	}
}
