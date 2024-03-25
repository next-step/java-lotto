package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("도메인 Budget 테스트")
class BudgetTest {

    @DisplayName("구매 수량 테스트")
    @Test
    void canBuyQuantity() {
        Budget budget = new Budget(14000);
        int result = budget.canBuyQuantity();
        assertThat(result).isEqualTo(14);
    }
}
