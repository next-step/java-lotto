package com.nextstep.camp.calculator.domain.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTokenTest {

    @ParameterizedTest(name = "{0} {1} {2} = {3}")
    @MethodSource("provideOperatorAndOperands")
    void operate_valid(OperatorToken operator, int left, int right, int expected) {
        int result = operator.operate(left, right);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Object[]> provideOperatorAndOperands() {
        return Stream.of(
                new Object[]{OperatorToken.PLUS, 1, 2, 3},
                new Object[]{OperatorToken.MINUS, 5, 3, 2},
                new Object[]{OperatorToken.MULTIPLY, 4, 6, 24},
                new Object[]{OperatorToken.DIVIDE, 8, 2, 4}
        );
    }
}