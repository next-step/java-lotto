package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountTest {


	@DisplayName("금액이 주어질 때 로또금액만큼 나눠서 구매개수 리턴")
	@CsvSource(value = {"14000:14", "14000:14"}, delimiter = ':')
	@ParameterizedTest
	public void When_AmountDivideLottoAmount_Expected_Count(long amount, long count) {
		assertThat(new Amount(amount).divide(Lotto.LOTTO_PRICE))
			.isEqualTo(count);
	}

	@DisplayName("구매금액이 주어질 때 로또금액만큼 나눠지지 않는 경우 에러 발생")
	@ValueSource(longs = {14040, 0, 10, 1001})
	@ParameterizedTest
	public void When_AmountDivideLottoAmount_Expected_Exception(long purchaseAmount) {
		assertThatThrownBy(() -> new Amount(purchaseAmount).divide(Lotto.LOTTO_PRICE))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
