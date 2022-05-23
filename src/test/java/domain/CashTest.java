package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CashTest {
    @Test
    void create() {
        //given
        int cashAmount = 3000;

        //when
        Cash result = new Cash(cashAmount);

        //then
        assertThat(result).isEqualTo(new Cash(cashAmount));
    }

    @Test
    void capableLottoCount() {
        //given
        Cash cash = new Cash(3000);

        //when
        int result = cash.capableLottoCount(1000);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void isLessThan() {
        //given
        Cash cash = new Cash(2000);
        int comparedNumber1 = 3000;
        int comparedNumber2 = 1000;

        //when
        boolean result1 = cash.isLessThan(comparedNumber1);
        boolean result2 = cash.isLessThan(comparedNumber2);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @Test
    void isMultipleOf() {
        //given
        Cash cash = new Cash(2000);
        int price1 = 1000;
        int price2 = 999;

        //when
        boolean result1 = cash.isMultipleOf(price1);
        boolean result2 = cash.isMultipleOf(price2);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @Test
    void toBigDecimal() {
        //given
        Cash cash = new Cash(3000);

        //when
        BigDecimal result = cash.toBigDecimal();

        //then
        assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(3000));
    }
}
