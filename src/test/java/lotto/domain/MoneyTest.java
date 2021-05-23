package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}
