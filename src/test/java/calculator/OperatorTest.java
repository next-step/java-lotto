package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class OperatorTest {

    @ParameterizedTest
    @MethodSource("operatorProvider")
    @DisplayName("연산자에 따라서 정상적인 연산이 처리된다")
    void calculateTest(Operator operator, Number expectedNumber) {
        //given, when
        Number resultNumber = operator.calculate(new Number(4), new Number(2));

        //then
        Assertions.assertThat(resultNumber).isEqualTo(expectedNumber);
    }

    public static Stream<Arguments> operatorProvider() {
        return Stream.of(
                of(Operator.ADD, new Number(6)),
                of(Operator.SUBTRACT, new Number(2)),
                of(Operator.MULTIPLY, new Number(8)),
                of(Operator.DIVIDE, new Number(2))
        );
    }
}