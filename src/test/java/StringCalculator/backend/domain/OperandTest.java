package StringCalculator.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

class OperandTest {

    Operand operand;
    BinaryOperator<Integer> plusFormula;

    @BeforeEach
    void setUp(){
        operand = new Operand(3);
        plusFormula = Integer::sum;
    }

    @Test
    @DisplayName("음수입력시 에러 발생")
    void error_negative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Operand(-1));
    }

    @Test
    @DisplayName("연산자와 피연산자를 주입받아 계산")
    void evaluate() {
        int expected = operand.apply(plusFormula, new Operand(4));
        assertThat(expected).isEqualTo(7);
    }
}
