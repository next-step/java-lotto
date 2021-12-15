package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test
    @DisplayName("lt 테스트: money가 인자값보다 작으면 true, 그렇지 않으면 false를 리턴한다.")
    void lt() {
        Money money = new Money(5);

        assertTrue(money.lt(10));
        assertFalse(money.lt(1));
        assertFalse(money.lt(5));
    }

    @Test
    @DisplayName("isNotDivisibleBy 테스트: money가 인자값로 나누어떨어지면 false, 그렇지 않으면 true를 리턴한다.")
    void isNotDivisibleBy() {
        Money money = new Money(5000);

        assertFalse(money.isNotDivisibleBy(1000));
        assertTrue(money.isNotDivisibleBy(3000));
    }

    @Test
    @DisplayName("divideBy 테스트: money를 인자값으로 나눈 몫을 리턴한다.")
    void divideBy() {
        Money money = new Money(10000);

        assertEquals(10, money.divideBy(1000));
        assertEquals(5, money.divideBy(2000));
        assertEquals(2, money.divideBy(5000));
    }

}
