package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    public void 숫자_생성() {
        assertThat(new Number("1")).isEqualTo(new Number(1));
    }

    @Test
    public void 유효하지_않은_문자() {
        assertThatThrownBy(() -> new Number("-")).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 덧셈() {
        Number first = new Number("1");
        Number second = new Number("2");
        Operator operator = new Plus();

        assertThat(first.calculate(operator, second)).isEqualTo(new Number(3));
    }

    @Test
    public void 뺄셈() {
        Number first = new Number("3");
        Number second = new Number("2");
        Operator operator = new Substraction();

        assertThat(first.calculate(operator, second)).isEqualTo(new Number(1));
    }

    @Test
    public void 곱셈() {
        Number first = new Number("3");
        Number second = new Number("2");

        Operator operator = new Multiplication();
        assertThat(first.calculate(operator, second)).isEqualTo(new Number(6));
    }

    @Test
    public void 나눗셈() {
        Number first = new Number("4");
        Number second = new Number("2");

        Operator operator = new Division();
        assertThat(first.calculate(operator, second)).isEqualTo(new Number(2));
    }
}
