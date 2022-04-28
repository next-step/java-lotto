package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:+:3", "4:5:+:9", "5:2:*:10", "10:2:/:5"}, delimiter = ':')
    void operateTest(int number1, int number2, String operatorString, int result) {
        Operator operator = OperatorSelector.findOperator(operatorString);
        assertThat(operator.operate(number1, number2)).isEqualTo(result);
    }

    @DisplayName("사칙연산 테스트 - 실패 케이스")
    @Test
    void operateTestFail() {
        Operator operator = OperatorSelector.findOperator("/");
        assertThatIllegalArgumentException().isThrownBy(() -> operator.operate(5, 0));
    }
}
