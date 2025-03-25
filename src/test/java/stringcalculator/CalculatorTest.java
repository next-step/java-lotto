package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("두 숫자를 더한다.")
    void addTest() {
        //given
        int a = 1;
        int b = 2;
        final Calculator calculator = new Calculator();

        //when
        int result = calculator.add(a, b);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("두 숫자를 뺀다.")
    void subtractTest() {
        //given
        int a = 1;
        int b = 2;
        final Calculator calculator = new Calculator();

        //when
        int result = calculator.subtract(a, b);

        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("두 숫자를 곱한다.")
    void multiplyTest() {
        //given
        int a = 3;
        int b = 5;
        final Calculator calculator = new Calculator();

        //when
        int result = calculator.multiply(a, b);

        //then
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("두 숫자를 나눈다.")
    void divideTest() {
        //given
        int a = 10;
        int b = 5;
        final Calculator calculator = new Calculator();

        //when
        int result = calculator.divide(a, b);

        //then
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("null 이거나 blank 인 문자열을 받는 경우 에러를 던진다.")
    @MethodSource("provideNullOrBlankStrings")
    void nullOrBlankThenThrow(String input) {
        //given
        final Calculator calculator = new Calculator();

        //when & then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.splitWithSpace(input))
                .withMessageContaining("유효하지 않은 문자열입니다");
    }

    static Stream<String> provideNullOrBlankStrings() {
        return Stream.of(null, "", " ");
    }

    @Test
    @DisplayName("주어진 문자열을 공백 문자열로 나눠진 문자열 리스트를 반환한다.")
    void splitWithSpaceTest() {
        //given
        final String input = "2 + 3 * 4 / 2";
        final Calculator calculator = new Calculator();

        //when
        final List<String> result = calculator.splitWithSpace(input);

        //then
        Assertions.assertThat(result)
                .containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    @DisplayName("주어진 문자열 리스트로 사칙연산을 수행한다.")
    void processTest() {
        //given
        final List<String> input = List.of("2", "+", "3", "*", "4", "/", "2");
        final Calculator calculator = new Calculator();

        //when
        final int result = calculator.process(input);

        // then
        Assertions.assertThat(result).isEqualTo(10);
    }
}
