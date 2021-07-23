package calculator.stringadder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    @DisplayName("입력 값이 null 이거나 비어있는 0을 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void returnZeroWhenInputIsNullOrEmpty(String inputString) {
        Assertions.assertThat(StringAddCalculator.calculate(inputString)).isZero();
    }

    @DisplayName(",와 :로 혹은 커스텀 구분자로 분리하여 값들을 모두 더한 후 반환한다.")
    @MethodSource
    @ParameterizedTest
    void splitUsingCommaAndColonThenReturnItsElements(String expressionString, int expectedValue) {
        assertThat(StringAddCalculator.calculate(expressionString)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> splitUsingCommaAndColonThenReturnItsElements() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("1:2:3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("//-\n1-2-3", 6),
                Arguments.of("// \n1 2 3", 6)
        );
    }

    @DisplayName("숫자 이외의 값이나 음수가 전달될 경우 RuntimeException 예외가 발생한다.")
    @ValueSource(strings = {"-1,0,1", "a:b:c", "-1,a,5"})
    @ParameterizedTest
    void throwExceptionWhenTokenIsNotNaturalNumber(String expressionString) {
        assertThatThrownBy(() -> StringAddCalculator.calculate(expressionString)).isInstanceOf(RuntimeException.class);
    }
}
