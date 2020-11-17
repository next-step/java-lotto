package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {

	@Test
	@DisplayName("로또 구입 금액에 따라 구입매수 출력 테스트")
	public void getPurchaseMessageTest() {
		LottoPurchase underTest = new LottoPurchase(14000);
		assertThat(underTest.getLottoCount()).isEqualTo(14);
	}
}
