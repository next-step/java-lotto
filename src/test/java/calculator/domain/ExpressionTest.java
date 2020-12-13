package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("입력된 표현식에 대한 테스트")
class ExpressionTest {

    @DisplayName("유효한 표현식 생성")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "1,2,3", "1:2:3", "1,2:3"})
    void createExpressionTest(String input) {
        // When
        Expression expression = new Expression(input);
        // Then
        assertAll(
                () -> assertThat(expression).isNotNull(),
                () -> assertThat(expression.getOperands()).isNotNull()
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
                () -> assertThat(expression.getOperands()).isNotNull()
        );
    }
}
