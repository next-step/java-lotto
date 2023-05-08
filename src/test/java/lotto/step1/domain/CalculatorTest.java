package lotto.step1.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("연산자_테스트")
    void 연산자별_결과_확인(MathOperation mathOperation, int a, int b, int expected) {
        assertThat(mathOperation.calc(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void 공백입력시_오류를_Throw(String input) {
        List<String> list = Arrays.asList(input.split(" "));
        assertThatThrownBy(() -> new Calculator(list)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 /"})
    void 피연산자_개수가_연산자_개수보다_하나만_작지_않을_경우_오류를_Throw(String input) {
        List<String> list = Arrays.asList(input.split(" "));
        assertThatThrownBy(() -> new Calculator(list).getResult()).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 ! 3 = 4 ."})
    void 연산자가_올바르지_않을때_오류를_Throw(String input) {
        List<String> list = Arrays.asList(input.split(" "));
        assertThatThrownBy(() -> new Calculator(list).getResult()).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void 입력값_계산_확인(String input) {
        List<String> list = Arrays.asList(input.split(" "));
        Calculator calculator = new Calculator(list);
        assertThat(calculator.getResult()).isEqualTo(10);
    }

    static Stream<Arguments> 연산자_테스트() {
        int a = 3;
        int b = 4;
        return Stream.of(
                Arguments.arguments(new Addition(), a, b, 7),
                Arguments.arguments(new Subtraction(), a, b, -1),
                Arguments.arguments(new Multiplication(), a, b, 12),
                Arguments.arguments(new Division(), a, b, 0)
        );
    }
}