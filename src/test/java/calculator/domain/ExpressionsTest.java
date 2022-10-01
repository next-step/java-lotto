package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionsTest {

    @DisplayName("완전한 계산식이 아닌 경우 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3 * 2 2", "3 * 2 *"})
    void error_not_complete_expression(final String input) {

        final Expression stringInput = new Expression(input);

        assertThatThrownBy(() -> new Expressions(stringInput.split()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산기를 잘못 입력하였습니다.");
    }
}
