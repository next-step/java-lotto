package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    void 공백인_경우() {
        assertThatThrownBy(() -> {
           Validation.checkNullOrBlank("   ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null인_경우() {
        assertThatThrownBy(() -> {
           Validation.checkNullOrBlank(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
