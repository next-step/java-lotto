package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @Test
    public void 금액은_음수일경우_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1000));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1000,1000", "4,0"})
    public void 거스름돈_계산(int amount1, int amount2) {
        assertThat(new Money(amount1).change(new Money(amount2))).isEqualTo(createChange(amount1, amount2));
    }

    private Money createChange(int amount1, int amount2) {
        if (amount2 == 0) {
            return new Money(amount1);
        }
        return new Money(amount1 % amount2);
    }
}
