package step1.domain;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperatorTest {

    @Test
    void 사칙연산_기호가_아닌_경우() {
        assertThatThrownBy(() -> {
            Operator.valueOfLabel("!");
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 더하기인_경우() {
        Operator operator = Operator.valueOfLabel("+");
        assertThat(operator).isEqualTo(Operator.ADD);
    }

    @Test
    void 빼기인_경우() {
        Operator operator = Operator.valueOfLabel("-");
        assertThat(operator).isEqualTo(Operator.SUBTRACT);
    }

    @Test
    void 곱하기인_경우() {
        Operator operator = Operator.valueOfLabel("*");
        assertThat(operator).isEqualTo(Operator.MULTIPLY);
    }

    @Test
    void 나누기인_경우() {
        Operator operator = Operator.valueOfLabel("/");
        assertThat(operator).isEqualTo(Operator.DIVIDE);
    }

}