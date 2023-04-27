package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringOperatorTest {

    @Test
    void 덧셈연산자() {
        StringOperator stringOperator = StringOperator.of("+");

        assertThat(stringOperator).isEqualTo(StringOperator.ADD);
    }

    @Test
    void 뺄셈연산자() {
        StringOperator stringOperator = StringOperator.of("-");

        assertThat(stringOperator).isEqualTo(StringOperator.SUB);
    }

    @Test
    void 나눗셈연산자() {
        StringOperator stringOperator = StringOperator.of("/");

        assertThat(stringOperator).isEqualTo(StringOperator.DIV);
    }

    @Test
    void 곱셈연산자() {
        StringOperator stringOperator = StringOperator.of("*");

        assertThat(stringOperator).isEqualTo(StringOperator.MUL);
    }

    @Test
    void 사칙연산_기호가_아님(){
        assertThatThrownBy(() -> StringOperator.of("&"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 두_수를_더한다() {
        int result = StringOperator.ADD.calc(1,2);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 두_수를_뺄셈한다() {
        int result = StringOperator.SUB.calc(3,1);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 두_수를_곱셈한다() {
        int result = StringOperator.MUL.calc(5,3);

        assertThat(result).isEqualTo(15);
    }

    @Test
    void 두_수를_나눗셈한다() {
        int result = StringOperator.DIV.calc(6,3);

        assertThat(result).isEqualTo(2);
    }
}
