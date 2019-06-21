package com.jaeyeonling.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTest {

    @DisplayName("기본 구분자로 split 한다.")
    @Test
    void should_return_default_separator_when_basic_expression() {
        final String expression = "1:2,3";

        final Separator separator = new Separator(expression);

        final String[] separateValue = separator.separate(expression);

        assertThat(separateValue).containsExactly("1", "2", "3");
    }
}
