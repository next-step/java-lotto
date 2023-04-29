package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import stringcalulator.Calculate;
import stringcalulator.model.Constant;

public class CalculateTest {

    @Test
    void 입력공식_유효성_검사() {
        String inputValue = "2 - 가";

        Assertions.assertThatThrownBy(
                        () -> new Calculate(inputValue)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.Exception.DOES_NOT_NUMBER_AND_SYMBOL);
    }

    @Test
    void 연산테스트() {
        String input = "2 + 3";

        Calculate calculate = new Calculate(input);
        calculate.operate();

        Assertions.assertThat(calculate.getResult()).isEqualTo(2d + 3d);
    }
}
