package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또게임 테스트")
public class LottoGameTest {

	LottoGame lottoGame;

	@BeforeEach
	void setUp() {
		lottoGame = new LottoGame(new TestRandomNumbersGenerator(new Integer[]{1, 2, 3, 4, 5, 6}));
	}

	@Test
	@DisplayName("로또를 모두 자동으로 구매하는 테스트")
	void purchaseAutoLottos() {
		PurchaseRequest purchaseRequest = new PurchaseRequest(new PurchaseAmount(14000));
		Lottos purchaseLottos = lottoGame.purchaseLottos(purchaseRequest);
		assertThat(purchaseLottos.size()).isEqualTo(14);
	}

	@Test
	@DisplayName("수동과 자동을 모두 포함하여 구매하는 테스트")
	void purchaseManualAutoLottos() {
		Lottos manaulLottos = new Lottos(
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6)
		);
		PurchaseRequest purchaseRequest = new PurchaseRequest(new PurchaseAmount(14000), manaulLottos);
		Lottos purchaseLottos = lottoGame.purchaseLottos(purchaseRequest);
		assertThat(purchaseLottos.size()).isEqualTo(14); //전체
	}

}
