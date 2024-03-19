package sequenceCalculatorTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import sequenceCalculator.ExpressionChecker;

public class ExpressionCheckerTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "57", "24", "185"})
    @DisplayName("입력이 숫자면 true")
    void isDigitTest(String input) {
        Assertions.assertThat(ExpressionChecker.isDigit(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a", "+", "/", "18/52"})
    @DisplayName("입력이 숫자가 아니면 false")
    void isNotDigitTest(String input) {
        Assertions.assertThat(ExpressionChecker.isDigit(input)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/", "*"})
    @DisplayName("입력시 사친연산이면 true")
    void isBasicOperationTest(String input) {
        Assertions.assertThat(ExpressionChecker.isBasicOperation(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"^", "&", "|", "!"})
    @DisplayName("입력시 사친연산이 아니면 IllegalArgumentException")
    void isNotBasicOperationTest(String input) {
        Assertions.assertThatThrownBy(() -> ExpressionChecker.isBasicOperation(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
