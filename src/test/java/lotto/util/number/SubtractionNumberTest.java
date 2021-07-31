package lotto.util.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionNumberTest {
    @Test
    void equalsTest() {
        assertThat(
                new SubtractionNumber(1000, 1).equals(
                        new SubtractionNumber(0, 2)
                )
        ).isFalse();

        assertThat(
                new SubtractionNumber(10, 5).equals(
                        new SubtractionNumber(20, 15)
                )
        ).isTrue();
    }

    @Test
    void hashCodeTest() {
        assertThat(
                new SubtractionNumber(10, 4).hashCode()
        ).isEqualTo(
                new SubtractionNumber(7, 1).hashCode()
        );

        assertThat(
                new SubtractionNumber(40, 10).hashCode()
        ).isEqualTo(
                new SubtractionNumber(50, 20).hashCode()
        );
    }
}