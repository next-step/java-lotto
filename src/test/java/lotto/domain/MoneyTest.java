package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @Test
    public void 금액은_음수일경우_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1_000));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1000,1000", "4,0"})
    public void 거스름돈_계산(int amount1, int amount2) {
        assertThat(new Money(amount1).change(new Money(amount2))).isEqualTo(createChange(amount1, amount2));
    }

    @Test
    public void 두_돈을_곱한다() {
        assertThat(new Money(1_000).multiply(3)).isEqualTo(new Money(1_000 * 3));
    }

    @Test
    public void 두_돈을_밴다() {
        assertThat(new Money(1_000).subtracted(new Money(999))).isEqualTo(new Money(1_000 - 999));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1000,false", "1001,1000,true"})
    public void 금액이_크면_true를_반환한다(int left, int right, boolean result) {
        assertThat(new Money(left).isOver(new Money(right))).isEqualTo(result);
    }

    private Money createChange(int amount1, int amount2) {
        if (amount2 == 0) {
            return new Money(amount1);
        }
        return new Money(amount1 % amount2);
    }
}
