package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @Test
    void 음수_돈_불가() {
        assertThatThrownBy(() -> {
            new Money(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 0 이상이어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"15000:15", "1234:1", "10:0", "190000:190"}, delimiter = ':')
    void 구매_횟수(int amount, int buyCount) {
        Money money = new Money(amount);
        assertThat(money.buyChance(1000)).isEqualTo(buyCount);
    }

    @Test
    void 음수가격_구매_불가() {
        assertThatThrownBy(() -> new Money(1000).buyChance(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("가격은 0보다 커야 합니다.");
    }

}
