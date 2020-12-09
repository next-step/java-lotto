package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("금액(Money) 테스트")
public class MoneyTest {

    @DisplayName("0 이상의 숫자를 범위로 한다.")
    @ParameterizedTest
    @ValueSource(longs = {0, 1000, 10000})
    void create(long value) {
        // when
        Money money = Money.valueOf(value);

        // then
        assertThat(money).isNotNull();
    }

    @DisplayName("음수는 허용하지 않는다.")
    @ParameterizedTest
    @ValueSource(longs = {-1, -10})
    void createNotAllowNegative(long value) {
        // when / then
        assertThrows(IllegalArgumentException.class, () -> Money.valueOf(value));
    }

    @DisplayName("금액을 더할 수 있다")
    @ParameterizedTest
    @CsvSource({
            "1000,2000,3000",
            "400,100,500"
    })
    void plus(long first, long second, long expected) {
        // when
        Money money = Money.valueOf(first);
        Money other = Money.valueOf(second);
        Money plus = money.plus(other);

        // then
        assertThat(plus).isEqualTo(Money.valueOf(expected));
    }

    @DisplayName("금액을 나눌 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "1000,2000,0",
            "400,100,4",
            "5500,1000,5"
    })
    void divide(long first, long second, int expected) {
        // when
        Money money = Money.valueOf(first);
        Money other = Money.valueOf(second);
        int divide = money.divide(other);

        // then
        assertThat(divide).isEqualTo(expected);
    }

    @DisplayName("금액을 곱할 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "1000,2,2000",
            "400,100,40000",
            "5500,10,55000"
    })
    void multiply(long value, int count, long expected) {
        // when
        Money money = Money.valueOf(value);
        Money multiply = money.multiply(count);

        // then
        assertThat(multiply).isEqualTo(Money.valueOf(expected));
    }

    @DisplayName("수익률을 구할 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "1000,2000,0.5",
            "400,100,4",
            "5500,1000,5.5"
    })
    void profitRate(long first, long second, double expected) {
        // when
        Money money = Money.valueOf(first);
        Money other = Money.valueOf(second);
        double profitRate = money.profitRate(other);

        // then
        assertThat(profitRate).isEqualTo(expected);
    }

    @DisplayName("수익률은 소수점 두번째 자리까지만 구한다.")
    @ParameterizedTest
    @CsvSource("100,300,0.33")
    void profitRateSecondScale(long first, long second, double expected) {
        // when
        Money money = Money.valueOf(first);
        Money other = Money.valueOf(second);
        double profitRate = money.profitRate(other);

        // then
        assertThat(profitRate).isEqualTo(expected);
    }
}
