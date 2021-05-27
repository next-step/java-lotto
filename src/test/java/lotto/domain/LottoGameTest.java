package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또게임 테스트")
public class LottoGameTest {

	LottoGame lottoGame;
	TestRandomNumbersGenerator testRandomNumbersGenerator;

	@BeforeEach
	void setUp() {
		lottoGame = new LottoGame();
		testRandomNumbersGenerator = new TestRandomNumbersGenerator(new Integer[]{1, 2, 3, 4, 5, 6});
	}

	@Test
	@DisplayName("로또를 모두 자동으로 구매하는 테스트")
	void purchaseAutoLottos() {
		PurchaseLottos purchaseLottos = lottoGame.purchaseLottos(new PurchaseRequest(14000), testRandomNumbersGenerator);
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
		PurchaseLottos purchaseLottos = lottoGame.purchaseLottos(new PurchaseRequest(14000, manaulLottos), testRandomNumbersGenerator);
		assertThat(purchaseLottos.size()).isEqualTo(14); //전체
		assertThat(purchaseLottos.getManualLottos()).hasSize(4); //수동
		assertThat(purchaseLottos.getAutoLottos()).hasSize(10); //자동
	}

	@Test
	@DisplayName("수동으로 구매할 로또개수가 총 구매금액을 초과하는 경우 예외발생 테스트")
	void purchaseWrongManualLottos() {
		Lottos manaulLottos = new Lottos(
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6)
		);

		assertThatThrownBy(() -> lottoGame.purchaseLottos(new PurchaseRequest(2000, manaulLottos), testRandomNumbersGenerator))
				.isInstanceOf(IllegalArgumentException.class);
	}

}
