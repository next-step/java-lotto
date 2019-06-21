package com.jaeyeonling.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionSeparatorTest {

    @DisplayName("기본 구분자로 split 한다.")
    @Test
    void should_split_when_basic_expression() {
        final String expression = "1:2,3";

        final ExpressionSeparator separator = ExpressionSeparator.of(expression);

        final String[] separateValue = separator.separate(expression);

        assertThat(separateValue).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자로 split 한다.")
    @Test
    void should_split_when_custom_expression() {
        final String expression = "//Q\n1Q2Q3Q4Q10";

        final ExpressionSeparator separator = ExpressionSeparator.of(expression);

        final String[] separateValue = separator.separate(expression);

        assertThat(separateValue).containsExactly("1", "2", "3", "4");
    }
}
