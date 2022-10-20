package step1.numbers;

import org.junit.jupiter.api.Test;
import step1.numbers.ExpressionAsNumbers;
import step1.numbers.Numbers;
import step1.operators.ExpressionAsOperators;
import step1.operators.Operators;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    void 숫자들은_계산을_할_수있다() {
        String expression  = "1 + 1 * 2";
        Numbers sut = new Numbers(new ExpressionAsNumbers(expression));

        Operators operators = new Operators(new ExpressionAsOperators(expression));
        assertThat(sut.calculatedResult(operators)).isEqualTo(4);
    }
}
