package lotto.domain;

import lotto.exception.NotPositiveException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @Test
    void NUll_또는_Blank() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new Money(null));

        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new Money(""));
    }

    @Test
    void 음수() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new Money("-1"));
    }
}
