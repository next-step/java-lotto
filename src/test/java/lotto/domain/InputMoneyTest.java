package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputMoneyTest {
    @Test
    void cretateTypeCheck() {
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> new InputMoney("asd"));
    }

    @Test
    void cretateMinNumber() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new InputMoney("999"));
    }
}