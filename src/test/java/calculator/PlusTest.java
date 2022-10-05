package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlusTest {
    @Test
    void 더하기() {
        //given
        Number one = Number.stringToNumberFactory("1");
        Number two = Number.stringToNumberFactory("2");

        //when
        ArithmeticOperation plus = new Plus();
        Number result = plus.calculate(one, two);

        //then
        assertThat(result).isEqualTo(Number.stringToNumberFactory("3"));
    }
}
