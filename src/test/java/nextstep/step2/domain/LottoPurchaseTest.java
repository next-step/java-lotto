package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {

	@Test
	@DisplayName("로또 구입 금액에 따라 구입매수 출력 테스트")
	public void getPurchaseMessageTest() {
		LottoPurchase underTest = new LottoPurchase(14_000);
		assertThat(underTest.getLottoCount()).isEqualTo(14);
	}

	@Test
	@DisplayName("로또 구입 금액이 부족한 테스트 ")
	public void getPurchaseErrorTest() {
		LottoPurchase underTest = new LottoPurchase(500);
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.getLottoCount())
				.withMessage("로또 구매금액이 부족합니다.");
	}
}
