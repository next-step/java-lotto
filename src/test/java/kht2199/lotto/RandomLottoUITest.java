package kht2199.lotto;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;

import kht2199.lotto.view.InputView;
import kht2199.lotto.view.RandomLottoUI;
import kht2199.lotto.view.ResultView;

/**
 *
 * @author heetaek.kim
 */
class RandomLottoUITest {

	private static RandomLottoUI randomLottoUI;

	@BeforeEach
	void setUp() {
		ResultView resultView = new ResultView();
		InputView inputView = new InputView();
		randomLottoUI = new RandomLottoUI(inputView, resultView);
	}

	// @ParameterizedTest
	// @DisplayName("구입 금액으로 구매할 수 있는 로또 갯수를 계산")
	// @MethodSource("calculateLottoCountSource")
	// void calculateLottoCount(int assets, int lottoPrice, int calculated) {
	// 	assertThat(randomLotto.calculateLottoCount(lottoPrice))
	// 		.isEqualTo(calculated);
	// }

	static Stream<Arguments> calculateLottoCountSource() {
		return Stream.of(
			Arguments.of(1000, 1000, 1),
			Arguments.of(10000, 1000, 10),
			Arguments.of(11000, 1000, 11),
			Arguments.of(11100, 1000, 11)
		);
	}

	// @ParameterizedTest
	// @DisplayName("로또 구매 후 정산")
	// @MethodSource("purchaseSource")
	// void purchase(int assets, int countsOfLotto, Integer remains, boolean exception)
	// 		throws LottoListEmptyException, AssetsNotEnoughException {
	// 	randomLotto.setAssets(assets);
	// 	if (exception) {
	// 		assertThatThrownBy(() -> randomLotto.purchase(countsOfLotto))
	// 			.isInstanceOf(AssetsNotEnoughException.class);
	// 		return;
	// 	}
	// 	randomLotto.purchase(countsOfLotto);
	// 	assertThat(randomLotto)
	// 		.hasFieldOrPropertyWithValue("assets", remains);
	// }

	static Stream<Arguments> purchaseSource() {
		return Stream.of(
			Arguments.of(10000, 10, 0, false), // 정상적인 상황
			Arguments.of(11000, 10, 1000, false), // 예산이 남는 상황
			Arguments.of(9000, 10, null, true) // 예산이 부족한 상황
		);
	}
}