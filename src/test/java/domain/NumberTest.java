package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    public void 숫자_생성() {
        assertThat(new Number("1")).isEqualTo(new Number(1));
    }
    @Test
    public void 덧셈() {
        Number first = new Number("1");
        Number second = new Number("2");
        Operator operator = new Plus();

        assertThat(first.calculate(operator, second)).isEqualTo(new Number(3));
    }
}
