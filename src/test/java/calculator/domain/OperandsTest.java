package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("피연산자들에 대한 테스트")
class OperandsTest {

    @DisplayName("단일 피연산자로 피연산자들을 초기화한다.")
    @Test
    void createOperandsWithSingleOperandTest() {
        // when & then
        assertThat(Operands.withSingleOperand()).isNotNull();
    }

    @DisplayName("다중 피연산자로 피연산자들을 초기화한다.")
    @ParameterizedTest
    @MethodSource("provideMultipleOperand")
    void createOperandsWithMultipleOperandTest(List<Operand> input) {
        // when & then
        assertThat(new Operands(input)).isNotNull();
    }

    @DisplayName("피연산자들의 피연산자 값의 총합을 구한다.")
    @ParameterizedTest
    @MethodSource("provideMultipleOperandAndSum")
    void sumTest(List<Operand> input, int expected) {
        // given
        Operands operands = new Operands(input);
        // when & then
        assertThat(operands.sum()).isEqualTo(expected);
    }

    static Stream provideMultipleOperand() {
        return Stream.of(
                Collections.singletonList(new Operand()),
                Arrays.asList(new Operand(), new Operand("1")),
                Arrays.asList(new Operand(), new Operand("1"), new Operand("2"))
        );
    }

    static Stream provideMultipleOperandAndSum() {
        return Stream.of(
                Arguments.of(Collections.singletonList(new Operand()), 0),
                Arguments.of(Arrays.asList(new Operand(), new Operand("1")), 1),
                Arguments.of(Arrays.asList(new Operand(), new Operand("1"), new Operand("2")), 3)
        );
    }
}
