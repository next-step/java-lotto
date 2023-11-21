package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class OperandTest {

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "#:false"}, delimiter = ':')
    void isOperand(String input, boolean expected) {
        Assertions.assertThat(Operand.isOperand(input)).isEqualTo(expected);
    }
}