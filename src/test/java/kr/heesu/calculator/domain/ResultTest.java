package kr.heesu.calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private Result result;

    @BeforeEach
    void setUp() {
        result = Result.of();
    }

    @Test
    void ResultTest() {
        int operand = 3;
        Operator operator = Operator.of();

        result.next(operand, operator);

        assertThat(result.getVal()).isEqualTo(3);
    }
}