package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class AmountTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 1500, 3400})
    void 백원단위_예외발생(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Amount(input);
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5"}, delimiter = ':')
    void 금액_수량으로_환산(int input, int result) {
        assertThat(new Amount(input).quantity())
                .isEqualTo(result);
    }
}
