package calculator.domain.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculableTypeTest {

    @Test
    void 인스턴스_반환() {
        String sum = "+";
        String sub = "-";
        String multi = "*";
        String division = "/";
        String init = "";

        assertThat(CalculableType.getCalculable(sum).getClass()).isSameAs(SumCalculator.class);
        assertThat(CalculableType.getCalculable(sub).getClass()).isSameAs(SubtractionCalculator.class);
        assertThat(CalculableType.getCalculable(multi).getClass()).isSameAs(MultiplicationCalculator.class);
        assertThat(CalculableType.getCalculable(division).getClass()).isSameAs(DivisionCalulcator.class);
        assertThat(CalculableType.getCalculable(init).getClass()).isSameAs(InitOperatorCalculator.class);
    }

    @Test
    void 잘못된_연산자_예외() {
        assertThatThrownBy(() -> CalculableType.getCalculable("{"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
