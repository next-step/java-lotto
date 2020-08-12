package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateUtilTest {

    @Test
    void validateEmptyExpression() {
        assertThat(ValidateUtil.validateEmptyExpression("")).isTrue();
        assertThat(ValidateUtil.validateEmptyExpression(null)).isTrue();
    }
}
