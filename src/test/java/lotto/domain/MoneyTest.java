package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"1400:700:2.00", "3000:1700:1.76", "5000:14000:0.35"}, delimiter = ':')
    @DisplayName("Money 나누기 테스트")
    void divide(long input1, long input2, double expected) {
        Money money1 = Money.from(input1);
        Money money2 = Money.from(input2);

        Money result = money1.divide(money2);

        assertThat(result.doubleValue()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1400:200:1600", "500:1200:1700", "2500:120:2620"}, delimiter = ':')
    @DisplayName("Money 합(더하기) 테스트")
    void sum(long input1, long input2, long expected) {
        Money money1 = Money.from(input1);
        Money money2 = Money.from(input2);

        Money result = money1.sum(money2);

        assertThat(result.longValue()).isEqualTo(expected);
    }
}
