package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AmountTest {
    @Test
    void create() {
        final Amount amount = new Amount(10000);

        assertThat(amount).isEqualTo(new Amount(10000));
    }

    @DisplayName("로또 금액보다 낮은 금액은 예외가 발생한다.")
    @Test
    void smallAmountTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Amount(500);
        });
    }

    @Test
    void divideTest() {
        final int result = new Amount(2000).divide(new Amount(1000));

        assertThat(result).isEqualTo(2);
    }
}