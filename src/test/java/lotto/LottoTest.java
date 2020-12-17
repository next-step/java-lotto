package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

	@DisplayName("구입 금액을 로또 금액(1000원)으로 최대 로또 구매 수를 구하는지 확인한다.")
	@ParameterizedTest
	@CsvSource(value = {"10000,10", "1234,1", "0,0"})
	void buyTest(int purchaseAmount, int numOfLotto) {

		Lottos lottos = LottoStore.buy(purchaseAmount);
		assertThat(lottos.size()).isEqualTo(numOfLotto);

		// String input = inputNumbers();
		// WinningLotto winningLotto = WinningLotto.of(input);
		// DrawResults results = winningLotto.compare(lottos);
		//
		// Prizes prizes = results.getPrizes();
		// System.out.println(prizes);
		//
		// RateOfProfit profit = prizes.calculateRateOfProfit();
		// System.out.println(profit);
	}

	@DisplayName("구입 금액이 0이하일 경우 예외처리를 확인한다.")
	@ParameterizedTest
	@ValueSource(ints = {-1, -100})
	void purchaseAmountLetterThanZeroExceptionTest(int purchaseAmount) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.buy(purchaseAmount));
	}
}
