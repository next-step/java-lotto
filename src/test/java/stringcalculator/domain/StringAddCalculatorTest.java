package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringAddCalculatorTest {

    @DisplayName("null또는 빈 문자열이 입력되면 0을 반환한다")
    @NullAndEmptySource
    @ParameterizedTest
    void nullOrEmpty(String empty) {
        long result = StringAddCalculator.execute(empty);

        assertThat(result).isEqualTo(0);
    }

    static Stream<Arguments> originalExpression() {
        return Stream.of(
                Arguments.of("1,2:3", 6),
                Arguments.of("7:1:5", 13),
                Arguments.of("7,1,5", 13)
        );
    }

    static Stream<Arguments> customExpression() {
        return Stream.of(
                Arguments.of("//a\n1a2a3", 6),
                Arguments.of("//!\n7!1!5", 13)
        );
    }

    @DisplayName(", 또는 :로 구분되는 수식 입력 시 덧셈 결과를 반환한다")
    @MethodSource("originalExpression")
    @ParameterizedTest
    void origin(String expression, long result) {
        assertThat(StringAddCalculator.execute(expression)).isEqualTo(result);
    }

    @DisplayName("//와 \n사이 커스텀구분자와 수식 입력 시 덧셈 결과를 반환한다")
    @MethodSource("customExpression")
    @ParameterizedTest
    void custom(String expression, long result) {
        assertThat(StringAddCalculator.execute(expression)).isEqualTo(result);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void single() {
        assertThat(StringAddCalculator.execute("1")).isEqualTo(1);
    }

}