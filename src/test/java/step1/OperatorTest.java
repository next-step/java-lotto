package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OperatorTest {

    @Test
    public void 덧셈_타입_반환_테스트() {
        Operator operator = Operator.findOperatorByUserInput('+');

        assertThat(operator).isEqualTo(Operator.PLUS);
    }

    @Test
    public void 뺄셈_타입_반환_테스트() {
        Operator operator = Operator.findOperatorByUserInput('-');

        assertThat(operator).isEqualTo(Operator.MINUS);
    }

    @Test
    public void 곱셈_타입_반환_테스트() {
        Operator operator = Operator.findOperatorByUserInput('*');

        assertThat(operator).isEqualTo(Operator.MULTIPLICATION);
    }

    @Test
    public void 나눗셈_타입_반환_테스트() {
        Operator operator = Operator.findOperatorByUserInput('/');

        assertThat(operator).isEqualTo(Operator.DIVISION);
    }

    @ParameterizedTest
    @ValueSource(chars = {'1', '(', ')', '&', 'a'})
    public void 연산기호가_아닌_Char_입력_시_예외_반환_테스트(char inputOperator) {
        assertThatThrownBy(() -> Operator.findOperatorByUserInput(inputOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
