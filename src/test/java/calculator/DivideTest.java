package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideTest {
    @Test
    void 나누기() {
        //given
        Number one = new Number("1");
        Number two = new Number("2");

        //when
        ArithmeticOperation divide = new Divide();
        Number result = divide.calculate(two, one);

        //then
        assertThat(result).isEqualTo(new Number("2"));
    }
}
