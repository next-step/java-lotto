package string_calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperatorTest {
    @ParameterizedTest(name = "{0}으로 {1}을 만들 수 있다")
    @MethodSource("getInputFor_사칙연산_기호_char로_enum_객체를_만들_수_있다")
    void 사칙연산_기호_char로_enum_객체를_만들_수_있다(char c, Operator operator) {
        assertThat(Operator.from(c)).isEqualTo(operator);
    }

    @ParameterizedTest(name = "{0}으로 {1}을 만들 수 있다")
    @MethodSource("getInputFor_사칙연산_기호_String으로_enum_객체를_만들_수_있다")
    void 사칙연산_기호_string으로_enum_객체를_만들_수_있다(String s, Operator operator) {
        assertThat(Operator.from(s)).isEqualTo(operator);
    }

    @ParameterizedTest(name = "{0}은 {1}과 {2}로 할당된 연산을 할 수 있고 결과는 {3}이다.")
    @MethodSource("getInputFor_할당된_사칙연산을_수행할_수_있다")
    void 할당된_사칙연산을_수행할_수_있다(Operator operator, int input1, int input2, int expected) {
        assertThat(operator.operate(input1, input2)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}이 주어지면 적절한 기호가 아니므로 예외가 발생한다.")
    @ValueSource(chars = {'a', '가', '1', '_', 'X', ' ', '$'})
    void 사칙연산_기호_char가_아니면_예외가_발생한다(char notOpChar) {
        assertThatThrownBy(() -> Operator.from(notOpChar)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}이 주어지면 적절한 기호가 아니므로 예외가 발생한다.")
    @ValueSource(strings = {"ADD", "6", "++", "-*", "-8"})
    void 사칙연산_기호_string이_아니면_예외가_발생한다(String notOpString) {
        assertThatThrownBy(() -> Operator.from(notOpString)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> getInputFor_사칙연산_기호_char로_enum_객체를_만들_수_있다() {
        return Stream.of(
                Arguments.arguments('+', Operator.ADD),
                Arguments.arguments('-', Operator.SUBTRACT),
                Arguments.arguments('*', Operator.MULTIPLY),
                Arguments.arguments('/', Operator.DIVIDE)
        );
    }

    private static Stream<Arguments> getInputFor_사칙연산_기호_String으로_enum_객체를_만들_수_있다() {
        return Stream.of(
                Arguments.arguments("+", Operator.ADD),
                Arguments.arguments("-", Operator.SUBTRACT),
                Arguments.arguments("*", Operator.MULTIPLY),
                Arguments.arguments("/", Operator.DIVIDE)
        );
    }

    private static Stream<Arguments> getInputFor_할당된_사칙연산을_수행할_수_있다() {
        return Stream.of(
                Arguments.arguments(Operator.ADD, 1, 2, 3),
                Arguments.arguments(Operator.SUBTRACT, 4, 3, 1),
                Arguments.arguments(Operator.MULTIPLY, 3, 4, 12),
                Arguments.arguments(Operator.DIVIDE, 10, 3, 3)
        );
    }
}
