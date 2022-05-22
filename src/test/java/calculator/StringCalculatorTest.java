package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class StringCalculatorTest {

    @Test
    void 입력값_검증_테스트() {

        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.inputValidateAndSplit(""));

        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.inputValidateAndSplit(null));

        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.inputValidateAndSplit("2 ? 3 + 4"));
    }

}
