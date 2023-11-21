package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.DivideExpression;
import calculator.domain.Variable;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DivideExpressionTest {

    @DisplayName("나눗셈을 합니다. - 결과가 정수인 나눗셈")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} / {1} = {2}")
    void divideCalculateResultMustInteger(Variable left, Variable right, Variable result){
        DivideExpression divideExpression = new DivideExpression(left, right);
        assertThat(divideExpression.calculate().value()).isEqualTo(result.value());
    }

    @DisplayName("나눗셈을 합니다. - 결과가 정수인 나눗셈")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} / {1} = {2}")
    void divideCalculateResultMustRealNumber(Variable left, Variable right, Variable result){
        DivideExpression divideExpression = new DivideExpression(left, right);
        assertThat(divideExpression.calculate().value()).isEqualTo(result.value());
    }

    private static Stream<Arguments> divideCalculateResultMustInteger(){
        return Stream.of(
            Arguments.of(Variable.of("10"), Variable.of("2"), Variable.of("5")),
            Arguments.of(Variable.of("100"), Variable.of("25"), Variable.of("4")),
            Arguments.of(Variable.of("-50"), Variable.of("5"), Variable.of("-10")),
            Arguments.of(Variable.of("0"), Variable.of("10"), Variable.of("0")),
            Arguments.of(Variable.of("123456"), Variable.of("789"), Variable.of("156")),
            Arguments.of(Variable.of("999"), Variable.of("-3"), Variable.of("-333"))
        );
    }

    private static Stream<Arguments> divideCalculateResultMustRealNumber(){
        return Stream.of(
            // 10 ÷ 3 = 3.333..., 소수점 이하는 버리고 3으로 검증
            Arguments.of(Variable.of("10"), Variable.of("3"), Variable.of("3")),
            // 100 ÷ 7 = 14.285..., 소수점 이하는 버리고 14로 검증
            Arguments.of(Variable.of("100"), Variable.of("7"), Variable.of("14")),
            // -50 ÷ 8 = -6.25, 소수점 이하는 버리고 -6으로 검증
            Arguments.of(Variable.of("-50"), Variable.of("8"), Variable.of("-6")),
            // 12345 ÷ 789 = 15.656..., 소수점 이하는 버리고 16로 검증
            Arguments.of(Variable.of("12345"), Variable.of("789"), Variable.of("16"))
        );
    }
}
