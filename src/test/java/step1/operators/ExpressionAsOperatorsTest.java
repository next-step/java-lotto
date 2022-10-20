package step1.operators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step1.operators.operator.Operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionAsOperatorsTest {

    @Test
    void 연산식로부터_산술_연산자를_추출할_수_있다() {
        String expression = "1 + 1";
        ExpressionAsOperators sut = new ExpressionAsOperators(expression);

        assertThat(sut.operators()).containsExactly(Operator.PLUS);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 올바른_연산식이_아닐_경우_예외가_발생한다(String expression) {
        ExpressionAsOperators sut = new ExpressionAsOperators(expression);

        assertThatThrownBy(() -> sut.operators())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("올바른 연산식이 아닙니다.");
    }
}
