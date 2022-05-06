package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"#", "^", "&"})
    void 사칙연산_기호가_아닌_경우(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.from(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"+,2,3,5", "-,6,3,3", "*,5,4,20", "/,20,2,10"}, delimiter = ',')
    void 사칙연산_테스트(String operateCode, String firstOperand, String secondOperand, String answer) {
        assertThat(Operator.calculate(operateCode, firstOperand, secondOperand)).isEqualTo(answer);
    }
}