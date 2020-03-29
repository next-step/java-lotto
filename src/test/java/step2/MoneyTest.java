package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Money;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {
    @Test
    @DisplayName("금액은 0보다 커야 하며, 로또 금액보다 커야 한다.")
    void validateMoneyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(-1);
        }).withMessage(Money.MONEY_NEGATIVE_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(200);
        }).withMessage(Money.MONEY_AMOUNT_ERROR);
    }
}
