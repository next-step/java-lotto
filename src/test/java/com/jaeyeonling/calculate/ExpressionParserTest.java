package com.jaeyeonling.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionParserTest {

    @DisplayName("계산식에서 순수한 계산식만 가져온다.")
    @Test
    void should_return_pure_expression_when_pure_expression() {
        final String pureExpression = "1|2:3";
        final String expression = ExpressionParser.parseExpressionStatement(pureExpression);

        assertThat(expression).isEqualTo(pureExpression);
    }

    @DisplayName("커스텀 계산식에서 순수한 계산식만 가져온다.")
    @Test
    void should_return_custom_expression_when_pure_expression() {
        final String customExpression = "//Q\n1Q2Q3Q4Q10";
        final String expression = ExpressionParser.parseExpressionStatement(customExpression);

        assertThat(expression).isEqualTo("1Q2Q3Q4Q10");
    }

}
