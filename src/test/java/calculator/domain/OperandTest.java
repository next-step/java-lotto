package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperandTest {
    @ParameterizedTest
    @CsvSource(value = {
            "+3, 3",
            "-3, -3",
            "0, 0",
            "+0, 0",
            "-0, 0"
    })
    void Operand_피연산자_생성(String numString, int num) {
        assertThat(new Operand(numString)).isEqualTo(new Operand(num));
    }

    @Test
    void Operand_피연산자_숫자가_아닌_경우() {
        assertThatThrownBy(() -> new Operand("+")).isInstanceOf(NumberFormatException.class);
    }
}
