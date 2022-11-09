package lotto.domain;

import lotto.exception.NotPositiveException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @ParameterizedTest
    @NullAndEmptySource
    void NUll_또는_Blank(String input) {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new Money(input));
    }

    @Test
    void 음수() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new Money("-1"));
    }
}
