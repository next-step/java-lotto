package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구매요청 테스트")
public class PurchaseRequestTest {

	private Lottos manaulLottos;

	@BeforeEach
	void setUp() {
		manaulLottos = new Lottos(
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6)
		);
	}

	@Test
	@DisplayName("수동으로 구매하려는 로또의 총 금액 계산 테스트")
	void calculateManualPurchaseAmount() {
		int manualPurchaseAmount = PurchaseRequest.calculateManualPurchaseAmount(manaulLottos);
		int resultPurchaseAmount = manaulLottos.size() * PurchaseAmount.AMOUNT_PER_UNIT;

		Assertions.assertThat(manualPurchaseAmount).isEqualTo(resultPurchaseAmount);
	}

	@Test
	@DisplayName("수동이 포함된 구매요청인경우 자동으로 구입할 로또는 몇개인지 테스트")
	void findNumberOfAutomaticPurchases() {
		PurchaseAmount purchaseAmount = new PurchaseAmount(14000);
		PurchaseRequest purchaseRequest = new PurchaseRequest(purchaseAmount, manaulLottos);

		Assertions.assertThat(purchaseRequest.findNumberOfAutomaticPurchases()).isEqualTo(10);
	}

}
