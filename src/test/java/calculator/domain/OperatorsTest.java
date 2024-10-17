package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

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
        String[] symbols = {"+", "-", "*", "/"};

        Operators operators = new Operators(symbols);
        Iterator<IntBinaryOperator> actual = operators.iterator();

        Iterator<IntBinaryOperator> expected = Arrays.stream(symbols)
                .map(Operation::findOperatorBySymbol)
                .collect(Collectors.toList())
                .iterator();

        Assertions.assertThat(actual)
                .toIterable()
                .containsExactlyElementsOf(() -> expected);
    }
}
