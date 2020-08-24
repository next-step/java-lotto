package domain;

import org.junit.jupiter.api.Test;

import static domain.InputValidation.inputValueValidate;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    void isNull() {
        assertThat(inputValueValidate("")).isEqualTo(0);
        assertThat(inputValueValidate(null)).isEqualTo(0);
    }
}
