package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringValidatorTest {

    @Test
    void string_validationCheck_isNullOrIsEmpty() {
        assertThat(StringValidator.check("")).isEqualTo(0);
        assertThat(StringValidator.check(null)).isEqualTo(0);
    }
}
