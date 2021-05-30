package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BudgetTest {
	@Test
	@DisplayName("예산 범위 내에 구매 가능한 로또 개수를 계산")
	void calculate_possible_count_within_budget() {
		Budget budget = new Budget(10000);
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

		assertThat(budget.getPossibleCount(Lottos.EMPTY_LOTTOS)).isEqualTo(10);
		assertThat(budget.getPossibleCount(lottos)).isEqualTo(9);
	}

	@Test
	@DisplayName("1000만원 이상의 금액은 받을 수 없음")
	void can_not_accept_over_10_million() {
		assertThatThrownBy(() -> new Budget(100000000))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("0원 미만의 금액은 받을 수 없음")
	void can_not_accept_under_0() {
		assertThatThrownBy(() -> new Budget(-1))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("같은 금액이면 같은 예산으로 판단")
	void same_amount_then_same_budget() {
		assertThat(new Budget(1000)).isEqualTo(new Budget(1000));
	}
}
