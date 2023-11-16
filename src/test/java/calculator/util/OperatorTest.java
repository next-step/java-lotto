package calculator.util;

import calculator.domain.Number;
import calculator.util.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperatorTest {

    @Test
    void 사칙연산_기호가_아닌_경우() {
        assertThatThrownBy(() -> {
            Operator.calculate(new Number(6), "!", new Number(2));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 더하기인_경우() {
        Number result = Operator.calculate(new Number(6), "+", new Number(2));
        assertThat(result.value()).isEqualTo(8);
    }

    @Test
    void 빼기인_경우() {
        Number result = Operator.calculate(new Number(6), "-", new Number(2));
        assertThat(result.value()).isEqualTo(4);
    }

    @Test
    void 곱하기인_경우() {
        Number result = Operator.calculate(new Number(6), "*", new Number(2));
        assertThat(result.value()).isEqualTo(12);
    }

    @Test
    void 나누기인_경우() {
        Number result = Operator.calculate(new Number(6), "/", new Number(2));
        assertThat(result.value()).isEqualTo(3);
    }

}
