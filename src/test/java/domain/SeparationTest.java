package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SeparationTest {

    Separation separation;

    @BeforeEach
    void setUp() {
        separation = new Separation();
    }

    @Test
    @DisplayName("숫자가 연속으로 들어올때")
    void number_in_a_row() {
        final String[] inputs = {"2", "2", "3"};
        assertThatThrownBy(() -> {
            separation.separate(inputs);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산자가 연속으로 들어올때")
    void operator_in_a_row() {
        final String[] inputs = {"2", "*", "+"};
        assertThatThrownBy(() -> {
            separation.separate(inputs);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산자가 가장 처음에 있을때")
    void operation_place_first() {
        final String[] inputs = {"*", "2", "+", "3"};
        assertThatThrownBy(() -> {
            separation.separate(inputs);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
