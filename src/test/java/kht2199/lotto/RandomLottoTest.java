package kht2199.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kht2199.lotto.view.InputView;
import kht2199.lotto.view.ResultView;

/**
 *
 * @author heetaek.kim
 */
class RandomLottoTest {

	RandomLotto lotto = new RandomLotto(new InputView(), new ResultView());

	@ParameterizedTest
	@DisplayName("구입 금액으로 구매할 수 있는 로또 갯수를 계산")
	@MethodSource("calculateLottoCountSource")
	void calculateLottoCount(int assets, int lottoPrice, int calculated) {
		assertThat(lotto.purchase(assets, lottoPrice))
			.isEqualTo(calculated);
	}


	public static Stream<Arguments> calculateLottoCountSource() {
		return Stream.of(
			Arguments.of(1000, 1000, 1),
			Arguments.of(10000, 1000, 10),
			Arguments.of(11000, 1000, 11),
			Arguments.of(11100, 1000, 11)
		);
	}
}