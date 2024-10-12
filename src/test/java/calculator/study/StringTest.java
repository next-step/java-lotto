package calculator.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    public static final String OPERATORS = "+-*/";

    @Test
    void 문자열_contains_False() {
        assertThat(OPERATORS.contains("X")).isFalse();
    }

    @Test
    void 문자열_contains_True() {
        assertThat(OPERATORS.contains("+")).isTrue();
    }

    @Test
    void 리스트출력() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(arr.toString()).isEqualTo("[1, 2, 3, 4, 5]");
    }
}
