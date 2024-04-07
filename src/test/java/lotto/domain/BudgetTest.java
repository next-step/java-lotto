package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("도메인 Budget 테스트")
class BudgetTest {

    @DisplayName("구매 수량 테스트")
    @Test
    void canBuyQuantity() {
        Budget budget = new Budget(14000);
        int result = budget.purchasableQuantity(Price.LOTTO);
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("100원 이하 입력 테스트")
    @Test
    void minBudgetTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Budget(14100))
                .withMessage("100원 단위는 입력할 수 없습니다: 14100");
    }
}
