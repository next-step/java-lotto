package lotto.generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @DisplayName("나누기")
    @Test
    void divide() {
        Money money = Money.wons(14500);
        long ticketCount = money.divide(1000L).longValue();
        assertThat(ticketCount).isEqualTo(14500/1000);
    }
}
