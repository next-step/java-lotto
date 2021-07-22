package string_add_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    @DisplayName("입력 값이 null 이거나 비어있는 0을 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void returnZeroWhenInputIsNullOrEmpty(String inputString) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        assertThat(stringAddCalculator.calculate(inputString)).isZero();
    }

    @DisplayName(",와 :로 분리하여 값들을 모두 더한 후 반환한다.")
    @MethodSource
    @ParameterizedTest
    void splitUsingCommaAndColonAndReturnItsElements(String expressionString, int expectedValue) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        assertThat(stringAddCalculator.calculate(expressionString)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> splitUsingCommaAndColonAndReturnItsElements() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("1:2:3", 6),
                Arguments.of("1,2:3", 6)
        );
    }
}
