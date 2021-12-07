package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AmountTest {
    @Test
    void create() {
        Amount amount = new Amount(3000);
        int game = amount.possibleGame();
        assertThat(game).isEqualTo(3);
    }

    @Test
    @DisplayName("돈은 1000원 단위로만 받는다.")
    void amountMustMultipleOf1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Amount(999);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Amount(1001);
        });
    }

    @Test
    void earnRate() {
        Amount amount = new Amount(3000);
        float rate = amount.earnRate(6000L);
        assertThat(rate).isEqualTo(2F);
    }
}
