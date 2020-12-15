package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
	private Money money;

	@BeforeEach
	void setUp() {
		money = new Money(14000);
	}

	@Test
	@DisplayName("입력 받은 가격으로 최대로 구매한 갯수를 반환한다.")
	void buyMaxTest() {
		assertThat(money.buyMax(new Price(1000))).isEqualTo(14);
	}
}