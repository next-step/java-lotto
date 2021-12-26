package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
	@ParameterizedTest(name = "구매금액 = {0}원")
	@ValueSource(ints = {0, 1001})
	@DisplayName("lotto 구매 금액 테스트")
	void lottoMoney(int num) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {new Money(num);});
	}
}