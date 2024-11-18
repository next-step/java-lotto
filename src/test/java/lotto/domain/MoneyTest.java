package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
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
    @CsvSource(value = {"1000,1000,false", "2000,1000,true"})
    public void 금액이_크면_true를_반환한다(int left, int right, boolean result) {
        assertThat(new Money(left).isOver(new Money(right))).isEqualTo(result);
    }

    @Test
    public void 천원단위가_아니면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(1001));
    }

    @Test
    public void 금액에서_천원지폐를_제거한다() {
        Money money = new Money(5000);
        assertThat(money.subtractedBill(3)).isEqualTo(new Money(5000 - 3000));
    }

    @Test
    public void 돈을_생성한다() {
        assertThatCode(() -> new Money(0)).doesNotThrowAnyException();
    }

    private Money createChange(int amount1, int amount2) {
        if (amount2 == 0) {
            return new Money(amount1);
        }
        return new Money(amount1 % amount2);
    }
}
