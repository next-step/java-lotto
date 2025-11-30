package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountTest {

    @Test
    void add() {
        assertThat(new Count(1).add(new Count(3))).isEqualTo(new Count(4));
    }

    @Test
    void subtract() {
        assertThat(new Count(1).add(new Count(3))).isEqualTo(new Count(4));
    }

    @Test
    void isNegative() {
    }

    @Test
    void isBiggerThan() {
    }
}