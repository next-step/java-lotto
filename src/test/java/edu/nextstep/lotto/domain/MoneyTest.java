package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Money: 사용자가 입력한 구매금액 원시값을 포장한 클래스")
class MoneyTest {

	@DisplayName("생성자: 숫자를 파라미터로 받아 Money 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		Money money = new Money(14000);
		assertThat(money)
			.isNotNull()
			.isInstanceOf(Money.class)
			.hasFieldOrPropertyWithValue("money", 14000);
	}

	@DisplayName("생성자: 음수가 들어오면 Exception 발생.")
	@Test
	public void generate_shouldException() {
		assertThatThrownBy(() -> new Money(-1000))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("howManyPurchase: 숫자를 파라미터로 받아 Money 객체를 정상적으로 생성하여 리턴함")
	@ParameterizedTest(name = "{0}원으로 {1}개 구매가능")
	@CsvSource(value = {"500,0", "14000,14", "14500,14"})
	void howManyPurchase(int money, int expected) {
		assertThat(new Money(money).howManyPurchase()).isEqualTo(expected);
	}

	@DisplayName("hasEnoughToPurchase: 현재 구입금액에서 수동으로 구매할 로또 수만큼 지불이 가능하면 true, 불가하면 false를 리턴함.")
	@ParameterizedTest
	@CsvSource(value = {"10000,5,true", "100,1,false", "10500,11,false"})
	void hasEnoughToPurchase(int money, int number, boolean expected) {
		assertThat(new Money(money).hasEnoughToPurchase(number)).isEqualTo(expected);
	}
}