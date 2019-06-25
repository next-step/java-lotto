package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class InputTest {

    private String[] result;

    @BeforeEach
    void setUp() {
        result = new String[]{"1", "2"};
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사용자 입력값이 빈 값(null, '')인지 확인")
    void isEmpty(String value) {
        Input input = new Input(value);
        assertThat(input.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("사용자 입력값 split (with comma)")
    void split() {
        Input input = new Input("1,2");
        assertThat(input.split()).containsExactly(result);
    }

    @Test
    @DisplayName("사용자 입력값 split (with colon)")
    void split2() {
        Input input = new Input("1:2");
        assertThat(input.split()).containsExactly(result);
    }

    @Test
    @DisplayName("사용자 입력값 split (with custom delimiter")
    void split3() {
        Input input = new Input("//;\n1;2");
        assertThat(input.split()).containsExactly(result);
    }
}
