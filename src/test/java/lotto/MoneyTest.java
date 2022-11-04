package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.Money;
import lotto.exception.ErrorMessage;
import lotto.exception.MoneyNegativeException;

class MoneyTest {

	@DisplayName("Money가 음수이면 MoneyNegativeException을 던진다.")
	@ParameterizedTest
	@ValueSource(ints = {-1, -2, -3, -4})
	void Should_Throw_Money_Negative_Exception_When_Money_Is_Negative(int value) {
		assertThatThrownBy(() -> {
			new Money(value);
		}).isInstanceOf(MoneyNegativeException.class)
			.hasMessage(ErrorMessage.MONEY_MUST_BE_POSITIVE.getMessage());
	}
}
