package calculator.cal;

import calculator.domain.StringCalculate;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class StringCalculateTest {

    @Test
    void 계산_메서드_테스트() {
        String[] input = {"2", "+", "3", "*", "4", "/", "5", "-", "1"};
        StringCalculate calculate = new StringCalculate(input, input);
        assertThat(calculate.calculates()).isEqualTo(3);
    }

}
