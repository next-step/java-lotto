package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseHistoryTest {

	@Test
	@DisplayName("구매 이력 생성 테스트")
	public void createLottoPurchaseHistory() {
		LottoPurchaseHistory lottoPurchaseHistory = new LottoPurchaseHistory(5,3);
		assertThat(lottoPurchaseHistory.getManualLottoCount()).isEqualTo(3);
		assertThat(lottoPurchaseHistory.getAutoLottoCount()).isEqualTo(5);
	}
}
