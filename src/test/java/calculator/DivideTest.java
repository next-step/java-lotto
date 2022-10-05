package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideTest {
    @Test
    void 나누기() {
        //given
        Number one = Number.stringToNumberFactory("1");
        Number two = Number.stringToNumberFactory("2");

        //when
        ArithmeticOperation divide = new Divide();
        Number result = divide.calculate(two, one);

        //then
        assertThat(result).isEqualTo(Number.stringToNumberFactory("2"));
    }
}
