package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiTest {
    @Test
    void 곱하기() {
        //given
        Number one = Number.stringToNumberFactory("1");
        Number two = Number.stringToNumberFactory("2");

        //when
        ArithmeticOperation multi = new Multi();
        Number result = multi.calculate(one, two);

        //then
        assertThat(result).isEqualTo(Number.stringToNumberFactory("2"));
    }
}
