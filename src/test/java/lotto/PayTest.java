package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PayTest {
    @Test
    void createPay() {
        Pay pay = new Pay(1000);
        assertThat(pay).isEqualTo(new Pay(1000));
    }

    @Test
    void payExcethion() {
        assertThatThrownBy(() -> new Pay(900))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
