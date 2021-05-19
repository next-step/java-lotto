package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(doubles = {-1, -0.10, -500})
    @DisplayName("돈에 음수값이 입력되면 예외 발생")
    void checkNegative(double input) {
        assertThatThrownBy(() -> new Money(BigDecimal.valueOf(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력금액은 음수가 될 수 없습니다.");
    }

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
