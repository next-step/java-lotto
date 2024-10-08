package calculator.domain;

import calculator.dto.CalculationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

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
    void 나눗셈은_정수만_반환() {
        assertThat(operand.divide(new Operand("3"))).isEqualTo(new Operand("3"));
    }

    @Test
    void 산술오류_0으로_나누기() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> operand.divide(new Operand("0")))
                .withMessageMatching("/ by zero");
    }

    @Test
    void 나눗셈() {
        assertThat(operand.divide(new Operand("1"))).isEqualTo(new Operand("10"));
    }

    @Test
    void 곱셈() {
        assertThat(operand.multiply(new Operand("1"))).isEqualTo(new Operand("10"));
    }

    @Test
    void 뺼셈() {
        assertThat(operand.subtract(new Operand("1"))).isEqualTo(new Operand("9"));
    }

    @Test
    void 덧셈() {
        assertThat(operand.add(new Operand("1"))).isEqualTo(new Operand("11"));
    }

    @Test
    void 숫자_변환() {
        assertThat(operand.toInt()).isEqualTo(10);
    }
}