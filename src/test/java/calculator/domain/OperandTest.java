package calculator.domain;

import calculator.dto.CalculationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperandTest {
    private Operand operand;

    @BeforeEach
    void setUp() {
        this.operand = new Operand("10");
    }

    @Test
    void 계산결과_반환() {
        assertThat(operand.toCalculationResult()).isEqualTo(new CalculationResult("10"));
    }

    @Test
    void 숫자_변환() {
        assertThat(operand.toInt()).isEqualTo(10);
    }
}