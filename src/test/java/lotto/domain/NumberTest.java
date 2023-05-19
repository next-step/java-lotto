package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberTest {
    @Test
    void numberTest_compareTo() {
        Number number = Number.from(3);
        Number number2 = Number.from(3);
        assertThat(number.compareTo(number2)).isEqualTo(0);
    }

    @Test
    void numberTest_StringToNumber() {
        assertThat(Number.from("1").getNumber()).isEqualTo(1);
    }

    @Test
    void numberTest_StringToNumber_NumberFormatException() {
        assertThatThrownBy(() -> Number.from(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(Number.ERROR_MESSAGE_INPUT_NOT_INTEGER);
    }

    @Test
    void numberTest_유효숫자() {
        assertThatThrownBy(() -> Number.from(46))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(Number.ERROR_MESSAGE_INPUT_NOT_VAILD_NUMBER);
    }

    @Test
    void numberTest_cache_numbers_compare() {
        assertThat(Number.from(1) == Number.from(1)).isTrue();
    }
}