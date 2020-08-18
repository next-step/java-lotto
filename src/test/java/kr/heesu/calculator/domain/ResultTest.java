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
        Number operand = new Number(3);

        result.plus(operand);

        assertThat(result.getVal().getVal()).isEqualTo(3);
    }
}