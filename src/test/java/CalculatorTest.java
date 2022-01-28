import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 계산기_동작_테스트() {
        // given
        Numbers numbers = new Numbers("1,5,3");
        StringCalculator stringCalculator = StringCalculator.from(numbers);

        // when
        Number result = stringCalculator.calculate();

        // then
        assertThat(result.getNumber()).isEqualTo(9);
    }
}
