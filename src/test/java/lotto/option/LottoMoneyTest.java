package lotto.option;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoMoneyTest {

	@ParameterizedTest
	@ValueSource(longs = {1000, 10000, 99000})
	void constructor_noException(long money) {
		assertDoesNotThrow(() -> new LottoMoney(money));
	}

	@ParameterizedTest
	@ValueSource(longs = {1, 999, 1001, 1999})
	void constructor_exception_charge(long money) {
		assertThatThrownBy(() -> new LottoMoney(money))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("charge");
	}

	@ParameterizedTest
	@ValueSource(longs = {0, -1, -1000})
	void constructor_exception_onlyPositive(long money) {
		assertThatThrownBy(() -> new LottoMoney(money))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("positive");
	}

	@ParameterizedTest
	@CsvSource(value = {"1000,1", "5000,5"})
	void getLottoBuyCount(int money, int buyCount) {
		assertThat(new LottoMoney(money).getLottoBuyCount()).isEqualTo(buyCount);
	}
}