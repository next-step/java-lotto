package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class CalculatorTest {

    @Test
    void 입력값_검증_테스트() {

        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.inputValidate(""));

        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.inputValidate(null));
    }
}
