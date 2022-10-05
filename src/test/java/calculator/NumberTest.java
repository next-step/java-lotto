package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {
    @Test
    void 숫자_Null() {
        Assertions.assertThatThrownBy(() -> {
            Number.stringToNumberFactory(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_빈공백() {
        Assertions.assertThatThrownBy(() -> {
            Number.stringToNumberFactory("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
