import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("calculate 메소드는 주어진 식을 계산하고 그 결과를 반환한다.")
    void calculate() {
        String[] tokens = {"2", "+", "3", "*", "4", "/", "2"};
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.calculate(tokens)).isEqualTo(10);
    }
}
