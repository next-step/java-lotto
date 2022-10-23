package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AmountTest {

    @Test
    void create() {
        Amount actual = new Amount(3);

        assertThat(actual).isEqualTo(new Amount(3));
    }

    @DisplayName("Amount는 음수 값이 들어오면 IllegalArgumentException를 반환한다.")
    @Test
    void valid() {
        assertThatThrownBy(() -> new Amount(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void minus() {
        Amount amount = new Amount(3);

        assertThat(amount.minus(2)).isEqualTo(new Amount(1));
    }
}
