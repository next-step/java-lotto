package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputMoneyTest {
    InputMoney inputMoney;

    @BeforeEach
    void create() {
        inputMoney = new InputMoney(10000);
    }

    @Test
    void validMoney() {
        Assertions.assertThatThrownBy(() -> {
            new InputMoney(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getAvailableLottoSize() {
        Assertions.assertThat(inputMoney.getAvailableLottoSize())
                .isEqualTo(10);
    }

    @Test
    void getMoney() {
        Assertions.assertThat(inputMoney.getMoney())
                .isEqualTo(10000);
    }
}