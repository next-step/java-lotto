package lotto.util;

import lotto.util.number.DivisionNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivisionNumberTest {

    @Test
    void equalsTest() {
        assertThat(
                new DivisionNumber(1, 1).equals(
                        new DivisionNumber(0, 1)
                )
        ).isFalse();

        assertThat(
                new DivisionNumber(10, 5).equals(
                        new DivisionNumber(20, 10)
                )
        ).isTrue();

        assertThat(
                new DivisionNumber(10, 4).equals(
                        new DivisionNumber(20, 8)
                )
        ).isTrue();
    }
}