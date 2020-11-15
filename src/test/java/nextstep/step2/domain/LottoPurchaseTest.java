package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {

	@Test
	@DisplayName("로또 구입 금액에 따라 구입매수 출력 테스트")
	public void getPurchaseMessageTest() {
		LottoPurchase underTest = new LottoPurchase(14000);
		assertThat(underTest.getPurchaseMessage()).isEqualTo("14개를 구매했습니다.");
	}
	@Test
	@DisplayName("로또 구입 금액은 천원이므로 나머지는 무시한다.")
	public void getLottoPurchaseTest() {
		LottoPurchase underTest = new LottoPurchase(15100);
		assertThat(underTest.getPurchaseMessage()).isEqualTo("15개를 구매했습니다.");
	}
}
