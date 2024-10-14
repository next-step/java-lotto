package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperandsTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 피연산자는_필수다(String[] operands) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operands(operands))
                .withMessage("피연산자를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "가", " ", " 1", "2 ", " 3 ", "4 5"})
    void 피연산자는_숫자다(String operand) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operands(operand))
                .withMessage("숫자를 입력해 주세요.");
    }

    @Test
    void iterator를_제공한다() {
        Operands operands = new Operands("1", "2", "3");
        Iterator<Integer> actual = operands.iterator();

        List<Integer> list = List.of(1, 2, 3);
        Iterator<Integer> expected = list.iterator();

        Assertions.assertThat(actual)
                .toIterable()
                .containsExactlyElementsOf(() -> expected);
    }
}
