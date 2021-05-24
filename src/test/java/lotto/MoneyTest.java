package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	void money는_음수인가() {
		assertThatThrownBy(() -> new Money(-1))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void money가_충분한가() {
		Money money1 = new Money(999);
		assertThat(money1.isEnough()).isFalse();
		Money money2 = new Money(1000);
		assertThat(money2.isEnough()).isTrue();
	}

	@Test
	void money로_구매가능한_갯수_판단() {
		Money money = new Money(456465);
		assertThat(money.buyCount()).isEqualTo(456);
	}
}
