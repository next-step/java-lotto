package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.factory.ManualLottoNumbersFactory;

public class LottoKioskTest {

	@Test
	public void issueTest() {
		LottoPayAmounts payAmounts = LottoPayAmounts.of("14000");
		LottoNumbers lottoNumbers1 = ManualLottoNumbersFactory.create("1,2,3,4,5,6");
		LottoNumbers lottoNumbers2 = ManualLottoNumbersFactory.create("10,11,12,13,14,15");
		LottoPurchaseArgument argument = LottoPurchaseArgument.of(payAmounts, Arrays.asList(lottoNumbers1, lottoNumbers2));

		Lottos lottos = LottoKiosk.issue(argument);
		assertThat(lottos.getPurchaseLottoCount()).isEqualTo(14);
	}
}
