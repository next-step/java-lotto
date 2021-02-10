package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class MoneyTest {

    @DisplayName("money init test")
    @Test
    void init() {
        int input = 500;
        Money money = Money.of(input);
        assertThat(money.getMoney()).isEqualTo(input);
    }
}