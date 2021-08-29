package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WalletTest {
	@DisplayName(value = "구입 금액에 해당하는 로또 개수를 반환")
	@CsvSource(value = {"14900,14", "10000,10", "5000,5", "0,0"})
	@ParameterizedTest
	void countLottoToBuy(int money, int expect) {
		int count = new Wallet(money).numberOfThingsToBuy();
		assertThat(count).isEqualTo(expect);
	}

	@DisplayName(value = "구매 개수에 해당하는 로또를 반환")
	@CsvSource(value = {"10000,5,5000", "7000,4,3000"})
	@ParameterizedTest
	void buyLotto(int money, int numberOfLotto, int change) {
		Wallet wallet = new Wallet(money);
		wallet.buyLotto(numberOfLotto);

		assertThat(wallet).isEqualTo(new Wallet(change));
	}
}
