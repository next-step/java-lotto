package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinusTest {
    @Test
    void 빼기() {
        //given
        Number one = new Number("1");
        Number two = new Number("2");

        //when
        ArithmeticOperation minus = new Minus();
        Number result = minus.calculate(one, two);

        //then
        assertThat(result).isEqualTo(new Number("-1"));
    }
}
