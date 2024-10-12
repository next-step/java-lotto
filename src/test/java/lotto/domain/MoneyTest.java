package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {
    @Test
    @DisplayName("천원 이하의 돈이 주어지면 예외가 발생한다.")
    void shouldRejectAmountBelowThousand() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Money(999));
    }

    @Test
    @DisplayName("돈은 천원 단위로 주어져야 한다.")
    void shouldOnlyAllowAmountInThousandUnits() {
        final Money money = new Money(3000);

        assertThat(money).isEqualTo(new Money(3000));
    }

    @Test
    @DisplayName("돈의 단위가 천원 단위로 떨어지지 않는 경우 예외가 발생한다.")
    void shouldThrowExceptionWhenMoneyIsNotDivisibleByThousand() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Money(1800));
    }
}
