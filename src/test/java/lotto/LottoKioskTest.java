package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoKioskTest {

	@Test
	public void issueTest() {
		Lottos lottos = LottoKiosk.issue(LottoPayAmounts.of("14000"));
		assertThat(lottos.getPurchaseLottoCount()).isEqualTo(14);
	}
}
