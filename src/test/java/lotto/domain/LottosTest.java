package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또(일급콜렉션) 테스트")
public class LottosTest {
	TestRandomNumbersGenerator randomNumbersGenerator;

	@BeforeEach
	void setup() {
		randomNumbersGenerator = new TestRandomNumbersGenerator(new Integer[]{1, 2, 3, 4, 5, 6});
	}

	@Test
	@DisplayName("로또를 모두 자동으로 구매하는 테스트")
	void purchaseAutoLottos() {
		Lottos purchaseLottos = new Lottos(randomNumbersGenerator, new PurchaseAmount(14000));
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
		Lottos purchaseLottos = new Lottos(randomNumbersGenerator, new PurchaseAmount(14000), manaulLottos);
		assertThat(purchaseLottos.size()).isEqualTo(14); //전체
	}

	@Test
	@DisplayName("수동으로 구매할 로또개수가 총 구매금액을 초과하는 경우 예외발생 테스트")
	void purchaseableAmountExceeded() {
		Lottos manaulLottos = new Lottos(
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6)
		);
		assertThatThrownBy(() -> new Lottos(randomNumbersGenerator, new PurchaseAmount(2000), manaulLottos))
				.isInstanceOf(IllegalArgumentException.class);
	}

}
