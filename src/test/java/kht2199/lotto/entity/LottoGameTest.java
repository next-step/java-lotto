package kht2199.lotto.entity;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kht2199.lotto.exception.assets.AssetsNotEnoughException;
import kht2199.lotto.exception.number.LottoNumberLengthException;
import kht2199.lotto.exception.number.LottoNumberRangeException;

class LottoGameTest {

	@ParameterizedTest
	@DisplayName("구입 금액으로 구매할 수 있는 로또 갯수를 계산")
	@MethodSource("calculatePurchasableLottoCountSource")
	void calculatePurchasableLottoCount(int assets, int calculated) {
		LottoGame game = new LottoGame();
		game.initiateAssets(assets);
		assertThat(game.calculatePurchasableLottoCount())
			.isEqualTo(calculated);
	}

	static Stream<Arguments> calculatePurchasableLottoCountSource() {
		return Stream.of(
			Arguments.of(1000, 1),
			Arguments.of(10000, 10),
			Arguments.of(11000, 11),
			Arguments.of(11100, 11)
		);
	}

	@ParameterizedTest
	@DisplayName("로또 구매 후 정산")
	@MethodSource("purchaseSource")
	void purchase(int assets, int countsOfLotto, Integer remains, boolean exception)
			throws AssetsNotEnoughException,
		LottoNumberLengthException,
		LottoNumberRangeException {
		LottoGame game = new LottoGame();
		game.initiateAssets(assets);
		LottoList list = new LottoList();
		while (countsOfLotto-- > 0) {
			list.addLotto(LottoNumber.valuesOf(1, 2, 3, 4, 5, 6));
		}
		if (exception) {
			assertThatThrownBy(() -> game.purchase(list))
				.isInstanceOf(AssetsNotEnoughException.class);
			return;
		}
		game.purchase(list);
		assertThat(game.getAssets())
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