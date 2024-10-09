import domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    public void 플러스_기호가_입력되면_덧셈한다() {
        assertThat(calculator.calculate("3 + 2")).isEqualTo(5);
    }

    @Test
    public void 마이너스_기호가_입력되면_덧셈한다() {
        assertThat(calculator.calculate("3 - 2")).isEqualTo(1);
    }

    @Test
    public void 곱셈_기호가_입력되면_곱셈한다() {
        assertThat(calculator.calculate("3 * 2")).isEqualTo(6);
    }

    @Test
    public void 나눗셈_기호가_입력되면_나눈다() {
        assertThat(calculator.calculate("6 / 3")).isEqualTo(2);
    }
    @Test
    public void 영으로_나눗셈_시도_시_ArithmeticException_이_발생한다() {
        assertThatThrownBy(() -> calculator.calculate("6 / 0"))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageMatching("0으로 나눌 수 없습니다.");
    }

}
