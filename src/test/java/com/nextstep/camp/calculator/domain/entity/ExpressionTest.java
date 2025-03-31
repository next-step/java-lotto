package com.nextstep.camp.calculator.domain.entity;

import java.util.stream.Stream;

import com.nextstep.camp.calculator.domain.vo.ExpressionTokens;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

    @ParameterizedTest(name = "{0} = {1}")
    @MethodSource("validExpressions")
    void evaluate_valid_expressions(String input, int expected) {
        Expression expression = Expression.of(ExpressionTokens.of(input));
        assertThat(expression.evaluate()).isEqualTo(expected);
    }

    static Stream<Object[]> validExpressions() {
        return Stream.of(
            new Object[]{"1 + 2", 3},
            new Object[]{"4 - 3", 1},
            new Object[]{"2 * 3", 6},
            new Object[]{"8 / 2", 4},
            new Object[]{"2 + 3 * 4 - 5 / 5", 3}
        );
    }

    @ParameterizedTest
    @MethodSource("invalidInputs")
    void evaluate_invalid_input_throws_exception(String input) {
        assertThatThrownBy(() -> Expression.of(ExpressionTokens.of(input)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> invalidInputs() {
        return Stream.of(
            null,
            "",
            "   "
        );
    }

    @Test
    @DisplayName("지원하지 않는 연산자는 IllegalArgumentException 발생")
    void evaluate_unsupported_operator_throws_exception() {
        String input = "2 % 3"; // '%'는 사칙연산 아님
        assertThatThrownBy(() -> Expression.of(ExpressionTokens.of(input)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}