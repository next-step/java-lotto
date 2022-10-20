package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionAsNumbersTest {

    @Test
    void 연산식로부터_양수를_추출할_수_있다() {
        String expression = "1 + 1";
        ExpressionAsNumbers sut = new ExpressionAsNumbers(expression);

        assertThat(sut.numbers()).containsExactly(1, 1);
    }
}
