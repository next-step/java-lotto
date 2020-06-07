package com.cheolhyeonpark.lotto.domain.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumbersTest {

    @Test
    void throwExceptionWhenWrongInput() {
        assertThatThrownBy(() -> new Numbers("a, b, c, d, e, f"))
                .hasMessage("There is non numeric input. Please check your input.");
    }

    @Test
    void throwExceptionWhenOverInput() {
        assertThatThrownBy(() -> new Numbers("1, 2, 3, 4, 5, 6, 7"))
                .hasMessage("Numbers size is not six. You should enter 6 numbers.");
    }

    @Test
    void throwExceptionWhenNoInput() {
        assertThatThrownBy(() -> new Numbers(""))
                .hasMessage("There is no input. Please check your input.");
    }

    @Test
    void testToString() {
        assertThat(new Numbers("1, 2, 3, 4, 5, 6").toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");

    }
}