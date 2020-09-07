package AutoLotto.domain.money;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    void canMakeMoney() {
        Money money1 = new Money(0);
        Money money2 = new Money(100);
        assertThat(money1.makeMoney()).isEqualTo(0);
        assertThat(money2.makeMoney()).isEqualTo(100);
    }

    @Test
    void checkPlusProfitBy() {
        Money money1 = new Money(14000);
        Money money2 = new Money(1400);
        assertThat(money1.isPlusProfitBy(5000)).isEqualTo(false);
        assertThat(money1.isPlusProfitBy(0)).isEqualTo(false);
        assertThat(money2.isPlusProfitBy(5000)).isEqualTo(true);
    }
}
