package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @ParameterizedTest(name = "연산자 : {0}, 피연산자1 : {1}, 피연산자2 : {2}, 연산결과 : {3}")
    @MethodSource("provideStringAndIndexAndChar")
    @DisplayName("성공 - 단일 사칙연산으로 원하는 결과값이 나온다.")
    void success_plus(String operator, int operand, int operand2, int result) {
        // when
        Operation operation = Operation.fromString(operator)
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호만 사용 가능합니다."));

        // then
        assertThat(operation.apply(operand, operand2)).isEqualTo(result);
    }

    private static Stream<Arguments> provideStringAndIndexAndChar() {
        return Stream.of(
                Arguments.of("+", 1, 2, 3),
                Arguments.of("-", 2, 1, 1),
                Arguments.of("*", 2, 3, 6),
                Arguments.of("/", 4, 2, 2)
        );
    }

}
