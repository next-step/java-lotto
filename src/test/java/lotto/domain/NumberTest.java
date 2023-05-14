package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberTest {
    @Test
    void numberTest_compareTo() {
        Number number = new Number(3);
        Number number2 = new Number(3);
        assertThat(number.compareTo(number2)).isEqualTo(0);
    }

    @Test
    void numberTest_StringToNumber() {
        assertThat(new Number("1").getNumber()).isEqualTo(1);
    }

    @Test
    void numberTest_StringToNumber_NumberFormatException() {
        assertThatThrownBy(() -> new Number(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(Number.ERROR_MESSAGE_INPUT_NOT_INTEGER);
    }

    @Test
    void numberTest_유효숫자() {
        assertThatThrownBy(() -> new Number(46))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(Number.ERROR_MESSAGE_INPUT_NOT_VAILD_NUMBER);
    }
}