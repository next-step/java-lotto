package AutoLotto.domain.money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BudgetTest {

    @Test
    void canMakeBudget() {
        assertThat(Budget.makeBudget("")).isEqualTo(0);
        assertThat(Budget.makeBudget("    ")).isEqualTo(0);
        assertThat(Budget.makeBudget("100")).isEqualTo(100);
    }
}
