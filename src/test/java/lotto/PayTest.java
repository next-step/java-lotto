package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PayTest {
    @Test
    void createPay() {
        Pay pay = new Pay(1000);
        assertThat(pay).isEqualTo(new Pay(1000));
    }

    @DisplayName("로또 살수 있는 갯수 ")
    @Test
    void name() {
        Pay pay = new Pay(2500);
        assertThat(2).isEqualTo(pay.countBuyLotto(1000));
    }

    @Test
    void payExcethion() {
        assertThatThrownBy(() -> new Pay(900))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
