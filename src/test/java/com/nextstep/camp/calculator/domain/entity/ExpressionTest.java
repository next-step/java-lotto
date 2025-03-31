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

    @ParameterizedTest(name = "{0}")
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

    @ParameterizedTest(name = "{0}")
    @MethodSource("invalidExpressions")
    void evaluate_unsupported_operator_throws_exception(String input) {
        assertThatThrownBy(() -> Expression.of(ExpressionTokens.of(input)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<String> invalidExpressions() {
        return Stream.of(
            "1 + 2 +",
            "4 - 3 *",
            "2 * 3 /",
            "8 / 2 +",
            "2 + 3 * 4 - 5 /"
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("invalidExpressionTokens")
    void evaluate_invalid_expression_tokens_throws_exception(String input) {
        assertThatThrownBy(() -> Expression.of(ExpressionTokens.of(input)))
            .isInstanceOf(IllegalArgumentException.class);
    }
    static Stream<String> invalidExpressionTokens() {
        return Stream.of(
            "1 + 2 % 3",
            "4 - (3 * 2)",
            "2 * 3 ! 4",
            "8 / 2 ~ 1",
            "2 + 3 ^^ 4 - 5 / 6",
            "1 + 2 + 3 - 4 * x / y"
        );
    }
}