package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlusTest {
    @Test
    void 더하기() {
        //given
        Number one = new Number("1");
        Number two = new Number("2");

        //when
        ArithmeticOperation plus = new Plus();
        Number result = plus.calculate(one, two);

        //then
        assertThat(result).isEqualTo(new Number("3"));
    }
}
