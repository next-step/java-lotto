package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
	@DisplayName("수동으로 구매할 로또개수가 총 구매금액을 초과하는 경우 예외발생 테스트")
	void purchaseableAmountExceeded() {
		Lottos manaulLottos = new Lottos(
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6)
		);
		assertThatThrownBy(() -> new PurchaseRequest(new PurchaseAmount(2000), manaulLottos))
				.isInstanceOf(IllegalArgumentException.class);
	}

}
