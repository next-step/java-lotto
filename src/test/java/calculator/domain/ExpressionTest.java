package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("입력된 표현식에 대한 테스트")
class ExpressionTest {

    @DisplayName("유효한 표현식 생성")
    @ParameterizedTest
    @MethodSource("provideExpressionAndSum")
    void createExpressionTest(String expression, int sum) {
        // When
        Expression actual = new Expression(expression);
        // Then
        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.sum()).isEqualTo(sum)
        );
    }

    @DisplayName("비어있거나 공백 표현식 생성")
    @ParameterizedTest
    @NullAndEmptySource
    void createExpressionWithNullAndEmptyTest(String input) {
        // When
        Expression expression = new Expression(input);
        // Then
        assertAll(
                () -> assertThat(expression).isNotNull(),
                () -> assertThat(expression.sum()).isZero()
        );
    }

    static Stream<Arguments> provideExpressionAndSum() {
        final int sum = 6;
        return Stream.of(
                Arguments.of("//;\n1;2;3", sum),
                Arguments.of("1,2,3", sum),
                Arguments.of("1:2:3", sum),
                Arguments.of("1,2:3", sum)
        );
    }
}
