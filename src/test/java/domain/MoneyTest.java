package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void 구입금액에_맞는_게임_수를_반환한다() {
        Money money = new Money(14500);

        assertThat(money.getGameCount()).isEqualTo(14);
    }
}
