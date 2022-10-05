package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    void of() {
        assertThat(Money.of(1)).isEqualTo(new Money(BigDecimal.valueOf(1)));
        assertThat(Money.of(1L)).isEqualTo(new Money(BigDecimal.valueOf(1L)));
    }

    @Test
    void add() {
        Money result = Money.of(8).add(Money.of(2));
        assertThat(result).isEqualTo(Money.of(10));
    }

    @Test
    void multiply() {
        Money result = Money.of(8).multiply(2);
        assertThat(result).isEqualTo(Money.of(16));
    }

    @Test
    void divide() {
        Integer result = Money.of(8).divide(Money.of(2));
        assertThat(result).isEqualTo(4);
    }

    @Test
    void divideWithScaleAndRoundingMode() {
        BigDecimal result = Money.of(100).divide(Money.of(3), 2, RoundingMode.FLOOR);
        BigDecimal expected = BigDecimal.valueOf(100).divide(BigDecimal.valueOf(3), 2, RoundingMode.FLOOR);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void remainder() {
        Money result = Money.of(8).remainder(Money.of(5));
        assertThat(result).isEqualTo(Money.of(3));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "14000,1000,true",
            "13500,1000,false"
    })
    void isDivisibleBy(Integer dividend, Integer divisor, Boolean expected) {
        boolean result = Money.of(dividend).isDivisibleBy(Money.of(divisor));
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "900,1000,true",
            "1000,1000,false",
            "2000,1000,false",
    })
    void isLesserThan(Integer left, Integer right, Boolean expected) {
        boolean result = Money.of(left).isLesserThan(Money.of(right));
        assertThat(result).isEqualTo(expected);
    }
}