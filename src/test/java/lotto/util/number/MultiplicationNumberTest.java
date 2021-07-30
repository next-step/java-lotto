package lotto.util.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationNumberTest {
    @Test
    void equalsTest() {
        assertThat(
                new MultiplicationNumber(1, 3).equals(
                        new MultiplicationNumber(0, 1)
                )
        ).isFalse();

        assertThat(
                new MultiplicationNumber(0, 3).equals(
                        new MultiplicationNumber(0, 1)
                )
        ).isTrue();

        assertThat(
                new MultiplicationNumber(10, 5).equals(
                        new MultiplicationNumber(25, 2)
                )
        ).isTrue();

        assertThat(
                new MultiplicationNumber(10, 4).equals(
                        new MultiplicationNumber(20, 2)
                )
        ).isTrue();
    }

    @Test
    void hashCodeTest() {
        assertThat(
                new MultiplicationNumber(10, 4).hashCode()
        ).isEqualTo(
                new MultiplicationNumber(2, 20).hashCode()
        );

        assertThat(
                new MultiplicationNumber(5, 4).hashCode()
        ).isEqualTo(
                new MultiplicationNumber(2, 10).hashCode()
        );
    }
}