package lotto.domain;

import org.assertj.core.api.Assertions;
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
	@DisplayName("구매금액이 로또를 구입하기 위한 최소금액이 안될경우 예외발생 테스트")
	void createLottoGame() {
		Assertions.assertThatThrownBy(() -> lottoGame.purchaseLottos(999, testRandomNumbersGenerator))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("구매금액으로 몇개의 로또를 구입할 수 있는지 테스트")
	void findNumberOfAvailablePurchases() {
		int lottoCount = lottoGame.findNumberOfAvailablePurchases(14000);
		assertThat(lottoCount).isEqualTo(14);
	}

	@Test
	@DisplayName("구매금액으로 로또를 구매하는 테스트")
	void purchaseLottos() {
		assertThat(lottoGame.purchaseLottos(14000, testRandomNumbersGenerator)).hasSize(14);
	}

}
