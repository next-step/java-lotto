package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MoneyTest {

    @Test
    public void 객체_생성() {
        Money money = new Money(100);
        assertThat(money.getValue()).isEqualTo(100);
    }

    @Test
    public void 천원_같거나클때_검증() {
        Money money = new Money(1000);
        assertThat(money.isLess(1000)).isFalse();
    }

    @Test
    public void 천원_보다작을때_검증() {
        Money money = new Money(999);
        assertThat(money.isLess(1000)).isTrue();
    }

    @Test
    public void 게임횟수_검증() {
        Money money = new Money(2000);
        assertThat(money.getGameTImes(1000)).isEqualTo(2);
    }

    @Test
    public void 수익률_검증() {
        Money money = new Money(14000);
        assertThat(money.calcurateProfitRate(5000)).isEqualTo(0.35714285714285715);
    }
}