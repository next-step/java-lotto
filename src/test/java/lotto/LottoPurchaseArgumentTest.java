package lotto;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.factory.ManualLottoFactory;

public class LottoPurchaseArgumentTest {

	@Test
	public void createLottoPurchaseArgumentTest() {
		LottoPayAmounts payAmounts = LottoPayAmounts.of("5000");
		Lotto lotto1 = ManualLottoFactory.create("1,2,3,4,5,6");
		Lotto lotto2 = ManualLottoFactory.create("10,11,12,13,14,15");

		LottoPurchaseArgument argument = LottoPurchaseArgument.of(payAmounts, Arrays.asList(lotto1, lotto2));


	}
}
