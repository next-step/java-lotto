package lotto;

import lotto.domain.LottoCalculator;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCalculatorTest {
	private static final int INIT_MONEY = 14000;
	private static final int GET_MONEY = 5000;
	private static final int GET_MONEY_ZERO = 0;
	private static final double RATE_OF_RETURN_ZERO = 0.0;
	private static final double RATE_OF_RETURN = 0.35;

	@Test
	@DisplayName("1000원 미만일 때, 로또 구매 불가 테스트")
	void purchaseMoneyErrorTest() {
		assertThatThrownBy(() -> LottoCalculator.getAvailableLottoNumbers(LottoNumbers.LOTTO_PRICE - 1))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1000원");
	}

	@Test
	@DisplayName("로또 수익률 계산 테스트")
	void rateOfReturnTest() {
		double returnMoney = LottoCalculator.getRateOfReturn(INIT_MONEY, GET_MONEY);
		assertThat(returnMoney).isEqualTo(RATE_OF_RETURN);
	}

	@Test
	@DisplayName("로또 수익률 계산 테스트")
	void rateOfReturnZeroTest() {
		double returnMoney = LottoCalculator.getRateOfReturn(INIT_MONEY, GET_MONEY_ZERO);
		assertThat(returnMoney).isEqualTo(RATE_OF_RETURN_ZERO);
	}

}
