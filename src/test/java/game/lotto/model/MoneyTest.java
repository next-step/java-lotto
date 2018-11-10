package game.lotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void 생성_테스트() {
        final int inputValue = 10000;
        Money money = new Money(inputValue);

        assertThat(money.getValue()).isEqualTo(inputValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_테스트_1000보다_작을때() {
        final int lowerNumber = 999;

        Money money = new Money(lowerNumber);
    }

    @Test
    public void 머니_동등성_비교() {
        final int inputValue = 20000;
        final Money origin = new Money(inputValue);
        final Money other = new Money(inputValue);

        assertThat(origin).isEqualTo(other);
    }

}