package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorSelectorTest {

    @DisplayName("operator를 찾는 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10:2:+:12", "10:2:-:8", "10:2:*:20", "10:2:/:5"}, delimiter = ':')
    void findOperatorTest(int number1, int number2, String symbol, int result) {
        Operator operator = OperatorSelector.findOperator(symbol);
        assertThat(operator.operate(number1, number2)).isEqualTo(result);
    }

    @DisplayName("operator를 찾는 기능 테스트 - 실패 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "#", "$", "%", "^", "더하기", "1"})
    void findOperatorTestFail(String operatorString) {
        assertThatIllegalArgumentException().isThrownBy(() -> OperatorSelector.findOperator(operatorString));
    }
}