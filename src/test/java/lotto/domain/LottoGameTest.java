package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
	@DisplayName("구매금액으로 로또를 구매하는 테스트")
	void purchaseLottos() {
		Lottos lottos = lottoGame.purchaseLottos(new PurchaseAmount(14000), testRandomNumbersGenerator);
		assertThat(lottos.size()).isEqualTo(14);
	}

}
