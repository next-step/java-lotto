package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class MoneyTest {

    private Money thousand;

    @BeforeEach
    void setUp() {
        thousand = Money.of(1000);
    }

    @Test
    @DisplayName("Money 생성 및 equals 테스트")
    void successByCreation() {
        assertThat(thousand).isEqualTo(Money.of(1000));
    }

    @ParameterizedTest
    @DisplayName("Money는 음수일 수 없다.")
    @ValueSource(ints = {-1, -5, -100})
    void exceptByCreation(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Money.of(input);
        }).withMessage(String.format("Money는 음수(%d)일 수 없습니다.", input));
    }

    @ParameterizedTest
    @DisplayName("Money minus 테스트")
    @CsvSource(value = {"100:900", "350:650", "1000:0"}, delimiter = ':')
    void minus(int input, int expected) {
        assertThat(thousand.minus(Money.of(input))).isEqualTo(Money.of(expected));
    }

    @ParameterizedTest
    @DisplayName("Money sum 테스트")
    @CsvSource(value = {"100:1100", "350:1350", "22300:23300"}, delimiter = ':')
    void sum(int input, int expected) {
        assertThat(thousand.sum(Money.of(input))).isEqualTo(Money.of(expected));
    }

    @ParameterizedTest
    @DisplayName("Money multiply 테스트")
    @CsvSource(value = {"100:100000", "350:350000", "2230:2230000"}, delimiter = ':')
    void multiply(int input, int expected) {
        assertThat(thousand.multiply(input)).isEqualTo(Money.of(expected));
    }

    @ParameterizedTest
    @DisplayName("Money를 Money로 나누면 count 반환")
    @CsvSource(value = {"99:10", "400:2", "800:1"}, delimiter = ':')
    void divide(int input, int expected) {
        assertThat(thousand.divide(Money.of(input))).isEqualTo(expected);
    }

    @Test
    @DisplayName("이익률 계산")
    void calculateProfit() {
        Money totalAmount = Money.of(200000);
        BigDecimal profitRate = totalAmount.calculateProfit(thousand);
        assertThat(profitRate).isEqualTo(new BigDecimal("200.00"));

        profitRate = totalAmount.calculateProfit(Money.of(30));
        assertThat(profitRate).isEqualTo(new BigDecimal("6666.67"));
    }
}