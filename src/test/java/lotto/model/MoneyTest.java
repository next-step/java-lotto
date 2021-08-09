package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.utils.LottoCountCalculator;

class MoneyTest {

	@ParameterizedTest
	@DisplayName("금액을 입력하면 금액이 반환된다.")
	@CsvSource(value = {"1000", "2000", "3000"})
	public void inputMoney(int money) {
		Money result = new Money(money);

		assertThat(result.getPurchaseMoney()).isEqualTo(money);
	}

	@ParameterizedTest
	@DisplayName("금액을 입력하면 로또 장수가 반환된다.")
	@CsvSource(value = {"1000,1", "2000,2", "3000,3"})
	public void inputMoneyAndCount(int money, int lottoCount) {
		Money result = new Money(money);

		assertThat(LottoCountCalculator.calculateLottoCount(result.getPurchaseMoney())).isEqualTo(lottoCount);
	}

	@Test
	@DisplayName("금액은 천단위가 아니면 예외가 발생한다.")
	public void checkThousandUnit() {
		assertThrows(IllegalArgumentException.class, () ->
			new Money(500)
		);
	}

	@Test
	@DisplayName("금액은 음수이면 예외가 발생한다.")
	public void checkPositive() {
		assertThrows(IllegalArgumentException.class, () ->
			new Money(-1)
		);
	}

}