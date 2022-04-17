package calculator;

import calculator.exception.InvalidOperatorException;
import calculator.model.Number;
import calculator.model.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.of;

class OperatorTest {

    @ParameterizedTest
    @MethodSource("operatorCalculateProvider")
    @DisplayName("연산자에 따라서 정상적인 연산이 처리된다")
    void calculateTest(Operator operator, Number expectedNumber) {
        //given, when
        Number resultNumber = operator.calculate(new Number(4), new Number(2));

        //then
        assertThat(resultNumber).isEqualTo(expectedNumber);
    }

    public static Stream<Arguments> operatorCalculateProvider() {
        return Stream.of(
                of(Operator.ADD, new Number(6)),
                of(Operator.SUBTRACT, new Number(2)),
                of(Operator.MULTIPLY, new Number(8)),
                of(Operator.DIVIDE, new Number(2))
        );
    }

    @ParameterizedTest
    @MethodSource("operatorValueProvider")
    @DisplayName("연산자 문자열과 일치하는 문자라면 연산자 객체를 반환한다")
    void fromTest(String operatorAsString, Operator expectedOperator) {
        //when
        Operator operator = Operator.from(operatorAsString);

        //then
        assertThat(operator).isEqualTo(expectedOperator);
    }

    public static Stream<Arguments> operatorValueProvider() {
        return Stream.of(
                of("+", Operator.ADD),
                of("-", Operator.SUBTRACT),
                of("*", Operator.MULTIPLY),
                of("/", Operator.DIVIDE)
        );
    }

    @Test
    @DisplayName("적절한 연산자 문자열이 아닐 경우 예외를 발생시킨다")
    void invalidOperatorTest() {
        assertThatThrownBy(() -> Operator.from("?")).isInstanceOf(InvalidOperatorException.class);
    }

}