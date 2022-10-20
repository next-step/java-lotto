package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionAsOperatorsTest {

    @Test
    void 연산식로부터_산술_연산자를_추출할_수_있다() {
        String expression = "1 + 1";
        ExpressionAsOperators sut = new ExpressionAsOperators(expression);

        assertThat(sut.operators()).containsExactly(Operator.PLUS);
    }
}
