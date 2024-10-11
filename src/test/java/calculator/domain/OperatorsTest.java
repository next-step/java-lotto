package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorsTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 연산자는_필수다(String[] operators) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operators(operators))
                .withMessage("연산자를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "%%", "*/-", "||"})
    void 연산자는_한_글자다(String operator) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operators(operator))
                .withMessage("사용할 수 없는 연산자입니다. : " + operator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"(", "^", "%", "1", "ㅁ", "a"})
    void 연산자는_사칙연산만_사용할_수_있다(String operator) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operators(operator))
                .withMessage("사용할 수 없는 연산자입니다. : " + operator);
    }

    @Test
    void iterator를_제공한다() {
        Operators operators = new Operators("+", "-", "*", "/");
        List<String> list = List.of("+", "-", "*", "/");
        Iterator<String> operatorsIterator = operators.iterator();
        Iterator<String> listIterator = list.iterator();

        while (operatorsIterator.hasNext()) {
            assertThat(operatorsIterator.next()).isEqualTo(listIterator.next());
        }
    }
}
