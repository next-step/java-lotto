package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

	@Test
	@DisplayName("음수로 Money 를 만들 수 없다.")
	public void negativeMoneyExceptionTest() {
		assertThatThrownBy(() -> Money.ofWons(-1000))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("Money 로 살 수 있는 로또 개수를 구할 수 있다.")
	@CsvSource(value = {"500:0", "1000:1", "1500:1"}, delimiter = ':')
	public void calculateLottoCountTest(int inputMoney, int expectedLottoCount) {
		Money money = Money.ofWons(inputMoney);
		Count lottoCount = money.countLotto();
		assertThat(lottoCount).isEqualTo(Count.of(expectedLottoCount));
	}
}
