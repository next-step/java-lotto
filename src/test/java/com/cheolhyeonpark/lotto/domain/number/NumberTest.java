package com.cheolhyeonpark.lotto.domain.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void throwExceptionWhenWrongNumber() {
        assertThatThrownBy(() -> new Number(0))
                .hasMessage("You should only enter numbers between 1 and 45.");
    }

    @Test
    void testHashCode() {
        assertThat(new Number(1).hashCode()).isEqualTo(new Number(1).hashCode());
    }
}