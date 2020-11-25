package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BudgetTest {

    @Test
    public void budget() {
        Budget budget = new Budget(14000);
        budget.setAmountOfManualLottos(3);

        assertThat(budget.getAmountOfAutoLottos()).isEqualTo(11);
    }

    @Test
    public void outOfRange_exception() {
        Budget budget = new Budget(14000);
        assertThatIllegalArgumentException().isThrownBy(
                () -> budget.setAmountOfManualLottos(15));
    }
}
