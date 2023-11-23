package StringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator cal;

    @BeforeEach
    void 초기화(){
        this.cal = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 공백테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.calculate(input);
        });
    }

    @Test
    void 덧셈테스트() {
        assertThat(cal.calculate("1 + 2")).isEqualTo(3);
    }

    @Test
    void 뺄셈테스트() {
        assertThat(cal.calculate("3 - 1")).isEqualTo(2);
    }

    @Test
    void 나눗셈테스트() {
        assertThat(cal.calculate("6 / 2")).isEqualTo(3);
    }

    @Test
    void 곱셈테스트() {
        assertThat(cal.calculate("2 * 3")).isEqualTo(6);
    }

}