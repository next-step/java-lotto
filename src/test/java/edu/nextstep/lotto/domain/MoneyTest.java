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

	@DisplayName("minusByNumberOfLotto: 현재 money에서 파라미터로 들어온 개수만큼 로또를 구매하여 money를 차감함")
	@Test
	void minusByNumberOfLotto() {
		Money money = new Money(2000);
		money.minusByNumberOfLotto(1);
		assertThat(money).hasFieldOrPropertyWithValue("money", 1000);
	}

	@DisplayName("minusByNumberOfLotto: 현재 money에서 파라미터로 들어온 개수만큼 로또를 구매하기에 충분치 않으면 예외 발생")
	@Test
	void minusByNumberOfLotto_shouldException() {
		assertThatThrownBy(() -> new Money(2000).minusByNumberOfLotto(3))
			.isInstanceOf(IllegalArgumentException.class);
	}
}