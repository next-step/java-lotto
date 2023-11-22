package lotto;

import lotto.domain.Cash;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CashTest {

    @Test
    void count() {
        Cash cash = new Cash(10000);
        int count = cash.count();

        assertThat(count).isEqualTo(10);
    }
}