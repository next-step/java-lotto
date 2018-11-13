package net.chandol.lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MoneyTest {

    @Test
    public void Money_덧셈_테스트() {
        Money money = Money.of(1000);
        Money result = money.add(Money.of(1000));

        assertThat(result).isEqualTo(Money.of(2000));
    }

    @Test
    public void Integer_덧셈_테스트() {
        Money money = Money.of(1000);
        Money result = money.add(500);

        assertThat(result).isEqualTo(Money.of(1500));
    }

    @Test
    public void Money_뺄셈_테스트() {
        Money money = Money.of(1000);
        Money result = money.subtract(Money.of(500));

        assertThat(result).isEqualTo(Money.of(500));
    }

    @Test
    public void Integer_뺄셈_테스트() {
        Money money = Money.of(1000);
        Money result = money.subtract(500);

        assertThat(result).isEqualTo(Money.of(500));
    }


    @Test
    public void Money_곱셈_테스트() {
        Money money = Money.of(1000);
        Money result = money.multiply(3);

        assertThat(result).isEqualTo(Money.of(3000));
    }

    @Test
    public void Money_나누기_테스트() {
        Money money = Money.of(1000);
        Money result = money.divide(Money.of(100));

        assertThat(result).isEqualTo(Money.of(10));
    }

    @Test
    public void Integer_나누기_테스트() {
        Money money = Money.of(1000);
        Money result = money.divide(100);

        assertThat(result).isEqualTo(Money.of(10));
    }

    @Test
    public void Integer_결과_나누기_테스트() {
        Money money = Money.of(1000);
        Integer result = money.divideAsNumber(Money.of(5));

        assertThat(result).isEqualTo(200);
    }

    @Test
    public void primitive값_구하기() {
        Money money = Money.of(1000);
        Integer moneyValue = money.getValue();

        assertThat(moneyValue).isEqualTo(1000);
    }
}