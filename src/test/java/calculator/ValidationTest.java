package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    @Test
    @DisplayName("공백 경우 IllegalArgumentException 반환")
    void 공백인_경우() {
        assertThatThrownBy(() -> {
           Validation.checkNullOrBlank("   ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null인 경우 IllegalArgumentException 반환")
    void null인_경우() {
        assertThatThrownBy(() -> {
           Validation.checkNullOrBlank(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
