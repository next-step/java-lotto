package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationTest {
    @Test
    void 곱하기() {
        //given
        Number one = new Number("1");
        Number two = new Number("2");

        //when
        ArithmeticOperation multi = new Multiplication();
        Number result = multi.calculate(one, two);

        //then
        assertThat(result).isEqualTo(new Number("2"));
    }
}
