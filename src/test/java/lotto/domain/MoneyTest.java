package lotto.domain;

import lotto.exception.NotPositiveException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @Test
    void 음수() {
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> new Money("-1"));
    }
}
