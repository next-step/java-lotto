package calculator;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExpressionTest {

    private static Stream<Arguments> provideStringsForAddNumbers() {
        return Stream.of(
                Arguments.of(Arrays.array("1", "2", "3"), 6),
                Arguments.of(Arrays.array("10", "20"), 30),
                Arguments.of(Arrays.array("100", "120", "50", "1"), 271)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForAddNumbers")
    @DisplayName("분리된 숫자들 더하기")
    void addNumbers(String[] input, int expected) {
        // given
        Expression expression = new Expression(input);

        // when
        int result = expression.addNumbers();

        // then
        assertThat(result).isEqualTo(expected);
    }


    @Test
    @DisplayName("Expression 생성 성공")
    void expression_success() {
        // when
        Expression expression = new Expression("1", "2", "10000");

        // then
        assertThat(expression).isEqualTo(new Expression("1", "2", "10000"));
    }


    private static Stream<Arguments> provideStringsForInvalidExpression() {
        return Stream.of(
                (Object) Arrays.array("-1", "2", "3"),
                Arrays.array("10", "-20"),
                Arrays.array("a00", "120", "50", "1")
        ).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForInvalidExpression")
    @DisplayName("Expression 생성시 인자가 양의 정수가 아닌경우 Exception 발생")
    void expression_throw_exception(String[] input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Expression expression = new Expression(input);
        }).withMessageContaining(CalculatorExceptionMessage.INVALID_NUMBER);
    }

}
