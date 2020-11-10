package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ExpressionTest {

    @DisplayName("of")
    @Nested
    class Of {
        @DisplayName("null이 전달된 경우")
        @Test
        void return_empty_expression_when_receive_null() {
            // when
            final Expression expression = Expression.of(null);
            
            // then
            assertThat(expression).isEqualTo(Expression.EMPTY_EXPRESSION);
        }

        @DisplayName("공백 문자열이 전달된 경우")
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "         "})
        void return_empty_expression_when_receive_blank(final String blank) {
            // when
            final Expression expression = Expression.of(blank);

            // then
            assertThat(expression).isEqualTo(Expression.EMPTY_EXPRESSION);
        }
    }


}