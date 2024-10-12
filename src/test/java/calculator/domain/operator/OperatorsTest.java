package calculator.domain.operator;

import calculator.domain.Operators;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorsTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 연산자는_필수다(String[] operators) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operators(operators))
                .withMessage("연산자를 입력해 주세요.");
    }

    @Test
    void iterator를_제공한다() {
        Operators operators = new Operators("+", "-", "*", "/");
        List<Operator> list = Stream.of("+", "-", "*", "/")
                .map(Operator::new)
                .collect(Collectors.toList());

        Iterator<Operator> operatorsIterator = operators.iterator();
        Iterator<Operator> listIterator = list.iterator();

        while (operatorsIterator.hasNext()) {
            assertThat(operatorsIterator.next()).isEqualTo(listIterator.next());
        }
    }
}
