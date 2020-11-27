package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BudgetTest {

    @Test
    public void isWithinBudget()  {
        assertThat(new Budget(10000).isWithinBudget(1000)).isTrue();
    }

    @Test
    public void overBudget_exception()  {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Budget(10000).addSpending(20000));
    }

}
