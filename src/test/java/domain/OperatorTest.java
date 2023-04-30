package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {
    @DisplayName("덧셈 연산을 테스트한다.")
    @ParameterizedTest
    @MethodSource("sampleExpression")
    public void 덧셈_테스트(List<Integer> numbers) throws Exception {
        assertThat(Operator.PLUS.calculate(numbers)).isEqualTo(numbers.get(0) + numbers.get(1));
    }

    @DisplayName("뺄셈 연산을 테스트한다.")
    @ParameterizedTest
    @MethodSource("sampleExpression")
    public void 뺄셈_테스트(List<Integer> numbers) throws Exception {
        assertThat(Operator.SUBTRACT.calculate(numbers)).isEqualTo(numbers.get(0) - numbers.get(1));
    }

    @DisplayName("곱셈 연산을 테스트한다.")
    @ParameterizedTest
    @MethodSource("sampleExpression")
    public void 곱셈_테스트(List<Integer> numbers) throws Exception {
        assertThat(Operator.MULTIPLY.calculate(numbers)).isEqualTo(numbers.get(0) * numbers.get(1));
    }

    @DisplayName("나눗셈 연산을 테스트한다.")
    @ParameterizedTest
    @MethodSource("sampleExpression")
    public void 나눗셈_테스트(List<Integer> numbers) throws Exception {
        assertThat(Operator.DIVIDE.calculate(numbers)).isEqualTo(numbers.get(0) / numbers.get(1));
    }

    static Stream<Arguments> sampleExceptionExpression() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(8, 0)),
                Arguments.of(Arrays.asList(9, 0)),
                Arguments.of(Arrays.asList(22, 0)),
                Arguments.of(Arrays.asList(21, 0))
        );
    }

    @DisplayName("나눗셈 예외를 테스트한다.")
    @ParameterizedTest
    @MethodSource("sampleExceptionExpression")
    public void 나눗셈_예외_테스트(List<Integer> numbers) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.DIVIDE.calculate(numbers));
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
