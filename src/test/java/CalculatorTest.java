import domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    public void 플러스_기호가_입력되면_덧셈한다() {
        assertThat(Calculator.calculate("3 + 2")).isEqualTo(5);
    }

    @Test
    public void 마이너스_기호가_입력되면_덧셈한다() {
        assertThat(Calculator.calculate("3 - 2")).isEqualTo(1);
    }


}
