package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionAsNumbersTest {

    @Test
    void 연산식로부터_양수를_추출할_수_있다() {
        String expression = "1 + 1";
        ExpressionAsNumbers sut = new ExpressionAsNumbers(expression);

        assertThat(sut.numbers()).containsExactly(1, 1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 올바른_연산식이_아닐_경우_예외가_발생한다(String expression) {
        ExpressionAsNumbers sut = new ExpressionAsNumbers(expression);

        assertThatThrownBy(() -> sut.numbers())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("올바른 연산식이 아닙니다.");
    }
}
