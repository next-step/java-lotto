package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    @DisplayName("문자열 기호로부터 올바른 Operator를 찾는다")
    void fromSymbol() {
        assertThat(Operator.from("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.from("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.from("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.from("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    @DisplayName("잘못된 기호는 IllegalArgumentException을 던진다")
    void invalidSymbol() {
        assertThatThrownBy(() -> Operator.from("%"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Operator가 PositiveNumber 연산을 수행한다")
    void applyOperation() {
        PositiveNumber left = PositiveNumber.from("2");
        PositiveNumber right = PositiveNumber.from("3");

        PositiveNumber plusResult = Operator.PLUS.apply(left, right);
        PositiveNumber minusResult = Operator.MINUS.apply(PositiveNumber.from("5"), right);

        assertThat(plusResult.toInt()).isEqualTo(5);
        assertThat(minusResult.toInt()).isEqualTo(2);
    }
}
