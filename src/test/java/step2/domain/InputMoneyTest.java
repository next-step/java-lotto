package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputMoneyTest {

    @DisplayName("InputMoney 인스턴스 생성 여부")
    @Test
    void 생성() {
        // given
        int inputValue = 15000;

        // then
        InputMoney inputMoney = InputMoney.valueOf(inputValue);

        // then
        assertThat(inputMoney).isNotNull();
    }
}