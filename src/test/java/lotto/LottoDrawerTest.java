package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDrawerTest {
	@ParameterizedTest(name = "[{index}] 입력받은 가격 {0} 만큼의 로또 {1}장을 발행한다")
	@CsvSource(value = {"1000:1", "5000:5", "14000:14", "14500:14", "16100:16", "19122140:19122"}, delimiter = ':')
	void drawLottosTest(int money, int numberOfLottos) {
		BigDecimal receivedMoney = BigDecimal.valueOf(money);

		Lottos lottos = LottoDrawer.draw(receivedMoney, Collections.emptyList());
		assertThat(lottos.lottos().size()).isEqualTo(numberOfLottos);
	}

	@Test
	@DisplayName("로또 번호를 생성한다")
	void drawLottoTest() {
		Lotto lotto = LottoDrawer.draw();
		assertThat(lotto.numbers().size()).isEqualTo(6);
	}

	@Test
	@DisplayName("1000원 미만의 돈을 입력받으면 익셉션이 발생한다")
	void lackOfMoneyTest() {
		BigDecimal receivedMoney = BigDecimal.valueOf(500);
		assertThatThrownBy(() -> LottoDrawer.draw(receivedMoney, Collections.emptyList()))
				.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest(name = "[{index}] 입력받은 가격만큼의 수동로또와 자동로또를 발행한다")
	@MethodSource(value = "generateLottoNumber")
	void manualDrawTest(List<List<Integer>> manualLottoNumbers) {
		BigDecimal receivedMoney = BigDecimal.valueOf(14000);
		Lottos lottos = LottoDrawer.draw(receivedMoney, manualLottoNumbers);
		assertThat(lottos.lottos().size()).isEqualTo(14);
	}

	private static Stream<Arguments> generateLottoNumber() {
		return Stream.of(
				Arguments.of(Arrays.asList(
						Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(1, 2, 3, 4, 5, 6)
				)),
				Arguments.of(Arrays.asList(
						Arrays.asList(1, 2, 3, 4, 5, 6),
						Arrays.asList(1, 2, 3, 4, 5, 6)
				)),
				Arguments.of(Collections.emptyList())
		);
	}

	@Test
	@DisplayName("입력받은 가격보다 수동로또 구매 개수가 많으면 익셉션이 발생한다")
	void lackOfMoneyToBuyManualLottosTest() {
		BigDecimal receivedMoney = BigDecimal.valueOf(2000);
		List<List<Integer>> manualLottoNumbers = Arrays.asList(
				Arrays.asList(1, 2, 3, 4, 5, 6),
				Arrays.asList(1, 2, 3, 4, 5, 6),
				Arrays.asList(1, 2, 3, 4, 5, 6),
				Arrays.asList(1, 2, 3, 4, 5, 6)
		);

		assertThatThrownBy(() -> LottoDrawer.draw(receivedMoney, manualLottoNumbers))
				.isInstanceOf(RuntimeException.class);
	}
}
