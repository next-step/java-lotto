package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("1 ~ 45숫자가 아닐 경우 IllegalArgumentException 발생하는지 확인한다.")
    void createNumberTest() {
        //given
        int number1 = 0;
        int number2 = 46;
        //when
        //then
        assertAll(
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.from(number1)),
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.from(number2))
        );
    }
}