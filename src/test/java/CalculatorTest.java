import domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

}
