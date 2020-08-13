package kr.heesu.calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void OperatorTest() {
        int result = Operator.of().operate(1, 2);
        assertThat(result).isEqualTo(3);
    }
}
