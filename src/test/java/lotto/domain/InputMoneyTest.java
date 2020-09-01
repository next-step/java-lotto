package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputMoneyTest {
    InputMoney inputMoney;

    @BeforeEach
    void create() {
        inputMoney = new InputMoney("3000");
    }

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

    @Test
    void testGetPaperCount() {
        Assertions.assertThat(inputMoney.getPaperCount()).isEqualTo(3);
    }

    @Test
    void makeWinningEarningsRate() {
        Assertions.assertThat(inputMoney.makeWinningEarningsRate())
                .isEqualToComparingFieldByField(new WinningEarningsRate(3000));
    }
}