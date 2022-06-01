package domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

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
    void createBigInteger() {
        //given
        BigInteger cashAmount = BigInteger.valueOf(3000);

        //when
        Cash result = new Cash(cashAmount);

        //then
        assertThat(result).isEqualTo(new Cash(cashAmount));
    }

    @Test
    void divide() {
        //given
        Cash dividend = new Cash(3000);
        Cash divisor = new Cash(1000);
        Cash expectedCash = new Cash(3);

        //when
        Cash result = dividend.divide(divisor);

        //then
        assertThat(result).isEqualTo(expectedCash);
    }

    @Test
    void multiply() {
        //given
        Cash cash = new Cash(3000);
        Cash expectedCash = new Cash(9000);

        //when
        Cash result = cash.multiply(3);

        //then
        assertThat(result).isEqualTo(expectedCash);
    }

    @Test
    void isLessThan() {
        //given
        Cash cash = new Cash(2000);
        Cash comparedCash1 = new Cash(3000);
        Cash comparedCash2 = new Cash(1000);

        //when
        boolean result1 = cash.isLessThan(comparedCash1);
        boolean result2 = cash.isLessThan(comparedCash2);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @Test
    void isMoreThan() {
        //given
        Cash cash = new Cash(2000);
        Cash comparedCash1 = new Cash(1000);
        Cash comparedCash2 = new Cash(3000);

        //when
        boolean result1 = cash.isMoreThan(comparedCash1);
        boolean result2 = cash.isMoreThan(comparedCash2);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @Test
    void isMultipleOf() {
        //given
        Cash cash = new Cash(2000);
        Cash price1 = new Cash(1000);
        Cash price2 = new Cash(999);

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
