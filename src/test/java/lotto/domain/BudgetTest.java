package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BudgetTest {
    @Test
    @DisplayName("음수 값으로 budget을 생성하려고 하면 IllegalArgumentException이 발생한다.")
    void negativeAmountTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Budget.valueOf(-1));
    }

    @Test
    @DisplayName("use하면 사용한 amount만큼 값이 적어진 budget을 반환합니다.")
    void useTest() {
        Budget budget = Budget.valueOf(10000);
        Budget budgetAfterUse = budget.use(1000);
        assertThat(budgetAfterUse).isEqualTo(Budget.valueOf(9000));
    }

    @Test
    @DisplayName("deposit하면 충전한 amount만큼 값이 많아진 budget을 반환합니다.")
    void depositTest() {
        Budget budget = Budget.valueOf(10000);
        Budget budgetAfterDeposit = budget.deposit(1000);
        assertThat(budgetAfterDeposit).isEqualTo(Budget.valueOf(11000));
    }
}