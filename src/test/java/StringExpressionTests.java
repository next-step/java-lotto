import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringAddCalculator.model.Expression;
import stringAddCalculator.model.Numbers;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class StringExpressionTests {

    @DisplayName("Expression 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2,3,1", "2:6,1"})
    public void createExpressionTest(String input) {
        assertThatCode(() -> Expression.newInstance(input)).doesNotThrowAnyException();
    }

    @DisplayName("Expression 생성 - 빈 문자열 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    public void createBlankExpressionTest(String input) {
        assertThat(Expression.newInstance(input)).isEqualTo(Expression.newInstance("0"));
    }

    @DisplayName("Numbers 합계 테스트")
    @ParameterizedTest
    @MethodSource("splitCases")
    public void splitExpressionTest(Expression expression, Numbers expectedResult) {
        assertThat(expression.split()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> splitCases() {
        return Stream.of(
                Arguments.of(Expression.newInstance("1"), Numbers.create(new String[]{"1"})),
                Arguments.of(Expression.newInstance("1,2"), Numbers.create(new String[]{"1", "2"})),
                Arguments.of(Expression.newInstance("1,2:3"), Numbers.create(new String[]{"1", "2", "3"})),
                Arguments.of(Expression.newInstance("//;\n1;2;3"), Numbers.create(new String[]{"1", "2", "3"}))
        );
    }
}
