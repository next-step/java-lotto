package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @ParameterizedTest(name = "문자열 : {0}, 인덱스 : {1}, 문자 : {2}")
    @MethodSource("provideOperatorAndNumber")
    @DisplayName("성공 - 사칙 연산이 2개 이상 일 경우 입력 값에 따라 계산이 된다.")
    void success_calculate(List<String> operators, List<Integer> numbers, int expected) {
        // given
        Calculator calculate = new Calculator();

        // when
        int result = calculate.calculate(operators, numbers);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOperatorAndNumber() {
        return Stream.of(
                Arguments.of(List.of("+", "*", "/"), List.of(2, 3, 4, 2), 10),
                Arguments.of(List.of("-", "/", "+"), List.of(10, 2, 2, 2), 6),
                Arguments.of(List.of("/", "*", "+"), List.of(12, 2, 8, 10), 58)
        );
    }

}
