package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BudgetTest {
	@Test
	@DisplayName("1000만원 이상의 금액은 받을 수 없음")
	void can_not_accept_over_10_million() {
		assertThatThrownBy(() -> new Budget("100000000"))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> new Budget(100000000))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("0원 미만의 금액은 받을 수 없음")
	void can_not_accept_under_0() {
		assertThatThrownBy(() -> new Budget("-1"))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> new Budget(-1))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("같은 금액이면 같은 예산으로 판단")
	void same_amount_then_same_budget() {
		assertThat(new Budget(100)).isEqualTo(new Budget(100));
		assertThat(new Budget("100")).isEqualTo(new Budget("100"));
	}
}
