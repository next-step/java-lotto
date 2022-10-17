package calculator.operator;

import calculator.domain.operator.Divide;
import calculator.domain.operator.Multiple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DivideTest {

    @Test
    @DisplayName("기본 나누기 테스트")
    void divide() {
        assertThat(new Divide(7).execute(21)).isEqualTo(3);
    }

    @Test
    @DisplayName("소수로 나눠질 때 0 이하는 버려진다")
    void divide_decimal() {
        assertThat(new Divide(3).execute(10)).isEqualTo(3);
    }

    @Test
    @DisplayName("0으로 나누기 테스트")
    void divide_by_zero() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> new Divide(0).execute(21))
                .withMessageContaining("/ by zero");
    }
}
