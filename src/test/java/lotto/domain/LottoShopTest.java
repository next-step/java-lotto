package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoShopTest {

	@DisplayName("구매 금액을 티켓 금액으로 나눠 티켓 수량을 계산한다.")
	@ParameterizedTest
	@CsvSource(value = {"0:0", "2000:2", "30000:30"}, delimiter = ':')
	void buy_lotto_ticket(int amount, int expected) {
		Assertions.assertThat(new LottoShop().sellTicket(amount)).isEqualTo(expected);
	}
}
