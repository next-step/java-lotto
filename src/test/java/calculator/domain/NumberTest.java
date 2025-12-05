package calculator.domain;

import calculator.domain.Number;
import calculator.domain.OperatorFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    public void 숫자_생성() {
        assertThat(new calculator.domain.Number("1")).isEqualTo(new calculator.domain.Number(1));
    }

    @Test
    public void 유효하지_않은_문자() {
        assertThatThrownBy(() -> new calculator.domain.Number("-")).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 덧셈() {
        calculator.domain.Number first = new calculator.domain.Number("1");
        calculator.domain.Number second = new calculator.domain.Number("2");

        assertThat(first.calculate(OperatorFactory.getOperator("+"), second)).isEqualTo(new calculator.domain.Number(3));
    }

    @Test
    public void 뺄셈() {
        calculator.domain.Number first = new calculator.domain.Number("3");
        calculator.domain.Number second = new calculator.domain.Number("2");

        assertThat(first.calculate(OperatorFactory.getOperator("-"), second)).isEqualTo(new calculator.domain.Number(1));
    }

    @Test
    public void 곱셈() {
        calculator.domain.Number first = new calculator.domain.Number("3");
        calculator.domain.Number second = new calculator.domain.Number("2");

        assertThat(first.calculate(OperatorFactory.getOperator("*"), second)).isEqualTo(new calculator.domain.Number(6));
    }

    @Test
    public void 나눗셈() {
        calculator.domain.Number first = new calculator.domain.Number("4");
        calculator.domain.Number second = new calculator.domain.Number("2");

        assertThat(first.calculate(OperatorFactory.getOperator("/"), second)).isEqualTo(new Number(2));
    }
}
