package step1;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @ParameterizedTest
    @MethodSource("nullOrEmptyInputSource")
    @DisplayName("Null 또는 공백의 입력이 들어왔을 때 결과로 0을 리턴하는지")
    void nullOrEmptyInput(String input, int result) {
        Calculator calculator = new Calculator();
        final int sum = calculator.apply(input);
        assertThat(sum).isEqualTo(result);
    }

    static Stream<Arguments> nullOrEmptyInputSource() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 0),
                Arguments.of("      ", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("singleNumberInputSource")
    @DisplayName("하나의 숫자만 들어왔을 때 결과로 그 숫자를 리턴하는지")
    void singleNumberInput(String input, int result) {
        Calculator calculator = new Calculator();
        final int sum = calculator.apply(input);
        assertThat(sum).isEqualTo(result);
    }

    static Stream<Arguments> singleNumberInputSource() {
        return Stream.of(
                Arguments.of("0", 0),
                Arguments.of("1", 1),
                Arguments.of(" 2", 2),
                Arguments.of("3 ", 3),
                Arguments.of(" 4 ", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("pluralNumberInputSource")
    @DisplayName("다수의 숫자가 들어왔을 때 정상적인 덧셈 결과를 리턴하는지")
    void pluralNumberInput(String input, int result) {
        Calculator calculator = new Calculator();
        final int sum = calculator.apply(input);
        assertThat(sum).isEqualTo(result);
    }

    static Stream<Arguments> pluralNumberInputSource() {
        return Stream.of(
                Arguments.of("0,1,2", 3),
                Arguments.of("1,2,3", 6),
                Arguments.of("2,3,4", 9),
                Arguments.of("3,4,5", 12),
                Arguments.of("4,5,6", 15)
        );
    }

    @ParameterizedTest
    @MethodSource("inValidNumberInputSource")
    @DisplayName("음수 또는 숫자이외의 문자가 들어왔을 때 결과로 ERROR 를 발생시키는지")
    void inValidNumberInput(String input) {
        assertThatThrownBy(() -> {
            Calculator calculator = new Calculator();
            calculator.apply(input);
        }).isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> inValidNumberInputSource() {
        return Stream.of(
                Arguments.of("-1"),
                Arguments.of("a"),
                Arguments.of("!")
        );
    }

    @ParameterizedTest
    @MethodSource("customSeparatorInputSource")
    @DisplayName("정상적인 커스텀 구분자를 사용하는 경우")
    void customSeparatorInput(String input, int result) {
        Calculator calculator = new Calculator();
        final int sum = calculator.apply(input);
        assertThat(sum).isEqualTo(result);
    }

    static Stream<Arguments> customSeparatorInputSource() {
        return Stream.of(
                Arguments.of("//;\n", 0),
                Arguments.of("//;\n1", 1),
                Arguments.of("//;\n1;3", 4),
                Arguments.of("//xx\n2", 2),
                Arguments.of("//xx\n2xx5", 7)
        );
    }

    @ParameterizedTest
    @MethodSource("inValidCustomSeparatorInputSource")
    @DisplayName("비정상적인 커스텀 구분자를 사용하는 경우")
    void inValidCustomSeparatorInput(String input) {
        assertThatThrownBy(() -> {
            Calculator calculator = new Calculator();
            calculator.apply(input);
        }).isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> inValidCustomSeparatorInputSource() {
        return Stream.of(
                Arguments.of("/n;\n"),
                Arguments.of("//;\t1")
        );
    }
}
