package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringOperatorTest {

    @DisplayName("OperatorString 생성 및 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4:2:+:6", "4:2:-:2", "4:2:*:8", "4:2:/:2"}, delimiter = ':')
    void createAndCalculateTest(int number1, int number2, String input, int result) {
        StringOperator operatorString = new StringOperator(input);
        assertThat(operatorString.calculate(number1, number2)).isEqualTo(result);
    }

    @DisplayName("OperatorString 생성 테스트 - 실패 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"!", "%", "@@", "+-"})
    void createTestFail(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new StringOperator(input));
    }
}
