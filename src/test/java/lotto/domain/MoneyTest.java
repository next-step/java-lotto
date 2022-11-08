package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void invalidAmount(final int amount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Money.wons(amount))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void validAmount(final int amount) {
        assertThatCode(() -> Money.wons(amount)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "5:10"}, delimiter = ':')
    void isLessThan_differentAmount(final int smallAmount, final int amount) {
        assertThat(Money.wons(smallAmount).isLessThan(Money.wons(amount))).isTrue();
        assertThat(Money.wons(amount).isLessThan(Money.wons(smallAmount))).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void isLessThan_sameAmount(final int amount) {
        assertThat(Money.wons(amount).isLessThan(Money.wons(amount))).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void divide_self(final int amount) {
        assertThat(Money.wons(amount).divide(Money.wons(amount)))
            .isEqualTo(Money.ONE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:0.5", "2:1:2", "4:2:2", "2:4:0.5", "3:5:0.6", "5:3:1.67",
        "100:10:10", "10:100:0.1"}, delimiter = ':')
    void divide_nonZero(final int amount1, final int amount2, final double expected) {
        assertThat(Money.wons(amount1).divide(Money.wons(amount2)))
            .isEqualTo(Money.wons(expected));
    }

}