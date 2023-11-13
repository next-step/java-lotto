package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationTest {
    @Test
    @DisplayName("두 수를 더 할 수 있다.")
    public void addition() {
        int result = Operation.addition(4, 5);
        Assertions.assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("두 수를 뺄 수 있다.")
    public void subtraction() {
        int result = Operation.subtraction(4, 5);
        Assertions.assertThat(result).isEqualTo(-1);
    }
    @Test
    @DisplayName("두 수를 곱 할 수 있다.")
    public void multiply() {
        int result = Operation.multiply(4, 5);
        Assertions.assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("두 수를 나눌 수 있다.")
    public void division() {
        int result = Operation.division(4, 5);
        Assertions.assertThat(result).isEqualTo(1);
    }
}
