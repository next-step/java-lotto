package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 문자열_계산() {
        //given
        StringCalculator stringCalculator = new StringCalculator();

        //when
        Number result = stringCalculator.calculate(Arrays.asList("1", "+", "2"));

        //then
        assertThat(result).isEqualTo(new Number(3));
    }
}
