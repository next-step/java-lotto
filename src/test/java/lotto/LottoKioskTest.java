package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoKioskTest {

	@Test
	public void issueTest() {
		LottoPayAmounts payAmounts = LottoPayAmounts.of("14000");
		String lottoNumbersString1 = "1,2,3,4,5,6";
		String lottoNumbersString2 = "10,11,12,13,14,15";
		LottoPurchaseArgument argument = LottoPurchaseArgument.of(payAmounts, Arrays.asList(lottoNumbersString1, lottoNumbersString2));

		Lottos lottos = LottoKiosk.issue(argument);
		assertThat(lottos.getPurchaseLottoCount()).isEqualTo(14);
	}
}
