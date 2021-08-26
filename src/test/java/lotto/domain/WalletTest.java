package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WalletTest {
	@DisplayName(value = "구입 금액에 해당하는 로또 개수를 발급하는지 테스트")
	@CsvSource(value = {"14900,14", "10000,10", "5000,5", "0,0"})
	@ParameterizedTest
	void buyLottos(int amount, int expect) {
		Lottos lottos = new Wallet().purchaseLottos(amount);
		int numberOfLotto = lottos.getNumberOfLottos();
		assertThat(numberOfLotto).isEqualTo(expect);
	}
}
