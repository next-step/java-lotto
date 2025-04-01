package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringOperationCalculatorTest {

    @Test
    public void calculate_null이나_빈값을_입력하는경우_exception_throw() {
        assertThatThrownBy(() -> StringOperationCalculator.calculate(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("input은 null 이거나, 빈값일 수 없습니다.");

        assertThatThrownBy(() -> StringOperationCalculator.calculate(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("input은 null 이거나, 빈값일 수 없습니다.");
    }

    @Test
    public void calculate_정상_케이스(){
        String input = "2 + 3 * 4 / 2";
        String result = StringOperationCalculator.calculate(input);
        assertThat(result).isEqualTo("10");
    }
}
