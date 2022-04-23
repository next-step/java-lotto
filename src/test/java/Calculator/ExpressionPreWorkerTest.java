package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static Calculator.ExpressionPreWorker.validateAndSplitExpression;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ExpressionPreWorkerTest {

    @ParameterizedTest(name = "expression: {0}")
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열인 경우 예외를 던진다.")
    public void validateTest(String expression) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            validateAndSplitExpression(expression);
        });
    }

    private static Stream<Arguments> expressionArgs() {
        return Stream.of(
                arguments("1 * 3", new String[]{"1", "*", "3"}),
                arguments("1 * 3 - 100", new String[]{"1", "*", "3", "-", "100"})
        );
    }

    @ParameterizedTest
    @MethodSource("expressionArgs")
    @DisplayName("공백 문자열이 있으면 split 으로 문자열을 나눈다.")
    public void splitTest(String expression, String[] splitArray) {
        assertThat(validateAndSplitExpression(expression)).isEqualTo(splitArray);
    }
}


