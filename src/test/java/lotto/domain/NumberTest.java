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
}