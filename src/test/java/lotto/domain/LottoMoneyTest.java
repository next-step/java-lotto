package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {

	@DisplayName("거슬러줘야 하는 돈을 받으면 IllegalArgumentException")
	@Test
	void paidMoneyToBeReturned_Then_IllegalArgumentException() {
		assertThatThrownBy(() -> LottoMoney.of(1100))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구매 가능한 수량을 계산한다")
	@ParameterizedTest
	@CsvSource({"10000, 0, 10", "10000, 10, 0"})
	void computePurchasableQuantity(int money, int alreadyOccupiedQuantity, int expected) {
		LottoMoney lottoMoney = LottoMoney.of(money);

		int quantity = lottoMoney.computePurchasableLottoQuantity(alreadyOccupiedQuantity);

		assertThat(quantity).isEqualTo(expected);
	}

	@DisplayName("돈으로 살 수 있는 로또 수량보다 구매 예정인 로또 수량이 더 많으면 IllegalArgumentException")
	@Test
	void alreadyOccupiedQuantityExceed_Then_IllegalArgumentException() {
		LottoMoney lottoMoney = LottoMoney.of(1000);

		assertThatThrownBy(() -> lottoMoney.computePurchasableLottoQuantity(2))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
