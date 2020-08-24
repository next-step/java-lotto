package domain;

import org.junit.jupiter.api.Test;

import static domain.InputValue.inputValueValidate;
import static org.assertj.core.api.Assertions.assertThat;

public class InputValueTest {
    @Test
    void isNull() {
        assertThat(inputValueValidate("")).isEqualTo(0);
        assertThat(inputValueValidate(null)).isEqualTo(0);
    }

    @Test
    void isOnly() {
        assertThat(inputValueValidate("3")).isEqualTo(3);
        assertThat(inputValueValidate("7")).isEqualTo(7);
    }
}
