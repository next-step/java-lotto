package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {
    @DisplayName("덧셈 연산을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"8:2", "12:4", "77:7", "36:6"}, delimiter = ':')
    public void 덧셈_테스트(int left, int right) throws Exception {

        assertThat(Operator.PLUS.calculate(left, right)).isEqualTo(left + right);
    }

    @DisplayName("뺄셈 연산을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"8:2", "12:4", "77:7", "36:6"}, delimiter = ':')
    public void 뺄셈_테스트(int left, int right) throws Exception {
        assertThat(Operator.SUBTRACT.calculate(left, right)).isEqualTo(left - right);
    }

    @DisplayName("곱셈 연산을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"8:2", "12:4", "77:7", "36:6"}, delimiter = ':')
    public void 곱셈_테스트(int left, int right) throws Exception {
        assertThat(Operator.MULTIPLY.calculate(left, right)).isEqualTo(left * right);
    }

    @DisplayName("나눗셈 연산을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"8:2", "12:4", "77:7", "36:6"}, delimiter = ':')
    public void 나눗셈_테스트(int left, int right) throws Exception {
        assertThat(Operator.DIVIDE.calculate(left, right)).isEqualTo(left / right);
    }

    @DisplayName("나눗셈 예외를 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"8:0", "12:0", "77:0", "36:0"}, delimiter = ':')
    public void 나눗셈_예외_테스트(int left, int right) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.DIVIDE.calculate(left, right));
    }

    static Stream<Arguments> sampleExpression() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(8, 2)),
                Arguments.of(Arrays.asList(9, 3)),
                Arguments.of(Arrays.asList(22, 2)),
                Arguments.of(Arrays.asList(21, 7))
        );
    }
}
