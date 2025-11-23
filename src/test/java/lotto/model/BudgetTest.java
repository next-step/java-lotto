package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BudgetTest {
    @Test
    @DisplayName("로또 구입 금액은 1000원 단위여야 한다.")
    public void validTest() {
        Budget budget = new Budget(10000);
        assertThat(budget).isEqualTo(new Budget(10000));
    }

    @Test
    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    public void invalidTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Budget(1500));
    }
}