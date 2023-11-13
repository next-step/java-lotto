package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationTest {
    @Test
    @DisplayName("두 수를 더 할 수 있다.")
    public void addition() {
        Number result = Operation.addition(4, 5);
        Assertions.assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("두 수를 뺄 수 있다.")
    public void subtraction() {
        Number result = Operation.subtraction(4, 5);
        Assertions.assertThat(result).isEqualTo(-1);
    }
}
