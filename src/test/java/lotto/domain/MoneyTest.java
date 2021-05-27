package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

	@DisplayName("로또 구입 금액 유효성 체크")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"asdf", ",", "   ", "0123"})
	void invalid(String money) {
		assertThatThrownBy(() -> new Money(money)).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1000:1", "10000:10", "100:0", "1200:1"}, delimiter = ':')
	void pay(String input, int expected) {
		// given
		Money money = new Money(input);
		int lottoPrice = 1000;

		// when
		int actual = money.divide(lottoPrice);

		// then
		assertThat(actual).isEqualTo(expected);
	}

}
