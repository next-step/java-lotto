package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinusTest {
    @Test
    void 빼기() {
        //given
        Number one = Number.stringToNumberFactory("1");
        Number two = Number.stringToNumberFactory("2");

        //when
        ArithmeticOperation minus = new Minus();
        Number result = minus.calculate(one, two);

        //then
        assertThat(result).isEqualTo(Number.stringToNumberFactory("-1"));
    }
}
