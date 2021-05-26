package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	@DisplayName("money에 음수를 차단하는지 확인")
	void money는_음수인가() {
		assertThatThrownBy(() -> new Money(-1))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("money가 로또를 구입하기 충분한지 확인")
	void money가_충분한가() {
		Money money1 = new Money(999);
		assertThat(money1.isEnough()).isFalse();
		Money money2 = new Money(1000);
		assertThat(money2.isEnough()).isTrue();
	}

	@Test
	@DisplayName("money로 구매 가능한 로또 갯수 확인")
	void money로_구매가능한_갯수_판단() {
		Money money = new Money(456465);
		assertThat(money.buyCount()).isEqualTo(456);
	}
}
