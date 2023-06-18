package edu.nextstep.camp.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;
    @BeforeEach
    void init(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void 연산(){
        int result = stringCalculator.calculate("1 + 2 + 3 - 4 * 2 / 2");

        assertThat(result).isEqualTo(2);
    }


}
