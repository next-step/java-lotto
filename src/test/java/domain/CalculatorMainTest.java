package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorMainTest {

    @DisplayName("수식 null, 공백 확인")
    @ParameterizedTest
    @NullAndEmptySource
    public void null_공백_확인(String exp) throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CalculatorMain.validExpression(exp));
    }

    @DisplayName("수식 숫자 분리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:1:2", "7 - 3:7:3"}, delimiter = ':')
    public void 숫자_분리(String expression, int left, int right) throws Exception {
        Numbers numbers = CalculatorMain.readNumbers(expression);
        assertThat(numbers.isContain(left)).isTrue();
        assertThat(numbers.isContain(right)).isTrue();
    }

    @DisplayName("수식 숫자 파싱 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 3*", "7 - &", "( - & * 12"})
    public void 숫자_분리_예외_발생(String expression) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> CalculatorMain.readNumbers(expression));
    }

    @DisplayName("수식 연산자 분리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:+", "7 - 3:-", "8 / 2:/", "12 * 231:*"}, delimiter = ':')
    public void 연산자_분리(String expression, String operation) throws Exception {
        assertThat(CalculatorMain.readOperators(expression).isContain(Operator.toOperation(operation))).isTrue();
    }

    @DisplayName("수식 연산자 파싱 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 7 3*", "7 123 &", "( - & . 12"})
    public void 연산자_분리_예외_발생(String expression) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> CalculatorMain.readOperators(expression));
    }

}
