package kht2199.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kht2199.lotto.exception.LottoListNotEmptyException;
import kht2199.lotto.exception.assets.AssetsNotEnoughException;
import kht2199.lotto.view.InputView;
import kht2199.lotto.view.ResultView;

/**
 *
 * @author heetaek.kim
 */
class RandomLottoTest {

	private static RandomLotto randomLotto;

	@BeforeAll
	static void beforeAll() {
		ResultView resultView = new ResultView();
		InputView inputView = new InputView(resultView);
		randomLotto = new RandomLotto(inputView, resultView);
	}

	@ParameterizedTest
	@DisplayName("구입 금액으로 구매할 수 있는 로또 갯수를 계산")
	@MethodSource("calculateLottoCountSource")
	void calculateLottoCount(int assets, int lottoPrice, int calculated) {
		assertThat(randomLotto.calculateLottoCount(assets, lottoPrice))
			.isEqualTo(calculated);
	}

	static Stream<Arguments> calculateLottoCountSource() {
		return Stream.of(
			Arguments.of(1000, 1000, 1),
			Arguments.of(10000, 1000, 10),
			Arguments.of(11000, 1000, 11),
			Arguments.of(11100, 1000, 11)
		);
	}

	@ParameterizedTest
	@DisplayName("로또 구매 후 정산")
	@MethodSource("purchaseSource")
	void purchase(int assets, int countsOfLotto, Integer remains, boolean exception)
			throws LottoListNotEmptyException, AssetsNotEnoughException {
		randomLotto.setAssets(assets);
		if (exception) {
			assertThatThrownBy(() -> randomLotto.purchase(countsOfLotto))
				.isInstanceOf(AssetsNotEnoughException.class);
			return;
		}
		randomLotto.purchase(countsOfLotto);
		assertThat(randomLotto)
			.hasFieldOrPropertyWithValue("assets", remains);
	}

	static Stream<Arguments> purchaseSource() {
		return Stream.of(
			Arguments.of(10000, 10, 0, false), // 정상적인 상황
			Arguments.of(11000, 10, 1000, false), // 예산이 남는 상황
			Arguments.of(9000, 10, null, true) // 예산이 부족한 상황
		);
	}
}