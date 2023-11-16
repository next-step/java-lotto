package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.DivideExpression;
import calculator.domain.VariableExpression;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DivideExpressionTest {

    @DisplayName("나눗셈을 합니다. - 결과가 정수인 나눗셈")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} / {1} = {2}")
    void divideCalculateResultMustInteger(VariableExpression left, VariableExpression right, VariableExpression result){
        DivideExpression divideExpression = new DivideExpression(left, right);
        assertThat(divideExpression.calculate().value()).isEqualTo(result.value());
    }

    @DisplayName("나눗셈을 합니다. - 결과가 정수인 나눗셈")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} / {1} = {2}")
    void divideCalculateResultMustRealNumber(VariableExpression left, VariableExpression right, VariableExpression result){
        DivideExpression divideExpression = new DivideExpression(left, right);
        assertThat(divideExpression.calculate().value()).isEqualTo(result.value());
    }

    private static Stream<Arguments> divideCalculateResultMustInteger(){
        return Stream.of(
            Arguments.of(VariableExpression.of("10"), VariableExpression.of("2"), VariableExpression.of("5")),
            Arguments.of(VariableExpression.of("100"), VariableExpression.of("25"), VariableExpression.of("4")),
            Arguments.of(VariableExpression.of("-50"), VariableExpression.of("5"), VariableExpression.of("-10")),
            Arguments.of(VariableExpression.of("0"), VariableExpression.of("10"), VariableExpression.of("0")),
            Arguments.of(VariableExpression.of("123456"), VariableExpression.of("789"), VariableExpression.of("156")),
            Arguments.of(VariableExpression.of("999"), VariableExpression.of("-3"), VariableExpression.of("-333"))
        );
    }

    private static Stream<Arguments> divideCalculateResultMustRealNumber(){
        return Stream.of(
            // 10 ÷ 3 = 3.333..., 소수점 이하는 버리고 3으로 검증
            Arguments.of(VariableExpression.of("10"), VariableExpression.of("3"), VariableExpression.of("3")),
            // 100 ÷ 7 = 14.285..., 소수점 이하는 버리고 14로 검증
            Arguments.of(VariableExpression.of("100"), VariableExpression.of("7"), VariableExpression.of("14")),
            // -50 ÷ 8 = -6.25, 소수점 이하는 버리고 -6으로 검증
            Arguments.of(VariableExpression.of("-50"), VariableExpression.of("8"), VariableExpression.of("-6")),
            // 12345 ÷ 789 = 15.656..., 소수점 이하는 버리고 16로 검증
            Arguments.of(VariableExpression.of("12345"), VariableExpression.of("789"), VariableExpression.of("16"))
        );
    }
}
