package calculator.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringTest {

    public static final String OPERATORS = "+-*/";

    @Test
    void 문자열_contains_False() {
        Assertions.assertThat(OPERATORS.contains("X")).isFalse();
    }

    @Test
    void 문자열_contains_True() {
        Assertions.assertThat(OPERATORS.contains("+")).isTrue();
    }
}
