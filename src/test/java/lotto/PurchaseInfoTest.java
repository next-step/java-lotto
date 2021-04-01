package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.PurchaseInfo;

public class PurchaseInfoTest {

	@Test
	@DisplayName("정상")
	void purchaseInfoTest_정상() {
		int purchasePrice = 5500;
		int purchaseManualNumber = 3;
		PurchaseInfo purchaseInfo = new PurchaseInfo(purchasePrice, purchaseManualNumber);
		assertThat(purchaseInfo.getPurchasePrice()).isEqualTo(5500);
		assertThat(purchaseInfo.getManualPurchaseNumbers()).isEqualTo(3);
		assertThat(purchaseInfo.calculateAutoPurchasePrice()).isEqualTo(2500);
		assertThat(purchaseInfo.calculateAutoPurchaseNumbers()).isEqualTo(2);
	}

	@Test
	@DisplayName("비정상 : 수동 갯수가 구입 금액보다 클 때")
	void purchaseInfoTest_비정상() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			int purchasePrice = 5000;
			int purchaseManualNumber = 6;
			new PurchaseInfo(purchasePrice, purchaseManualNumber);
		});

	}
}
