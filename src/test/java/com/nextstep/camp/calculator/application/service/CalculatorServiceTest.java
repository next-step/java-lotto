package com.nextstep.camp.calculator.application.service;

import com.nextstep.camp.calculator.application.dto.ExpressionRequest;
import com.nextstep.camp.calculator.domain.vo.ExpressionTokens;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("expressionProvider")
    void calculate(String expression, int expected) {
        ExpressionTokens tokens = ExpressionTokens.of(expression);
        ExpressionRequest request = new ExpressionRequest(tokens);

        int result = calculatorService.calculate(request).getResult();

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Object[]> expressionProvider() {
        return Stream.of(
                new Object[]{"1 + 2", 3},
                new Object[]{"2 + 3 * 4", 20},
                new Object[]{"10 - 5 + 2", 7},
                new Object[]{"6 / 2 * 3", 9},
                new Object[]{"100 - 50 / 5", 10}
        );
    }
}