package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class InputTest {

    private String[] result;

    @BeforeEach
    void setUp() {
        result = new String[]{"1", "2"};
    }

    @Test
    @DisplayName("사용자 입력값이 빈 값(null, '')인지 확인")
    void isEmpty() {
        Input input1 = new Input("");
        assertThat(input1.isEmpty()).isTrue();

        Input input2 = new Input(null);
        assertThat(input2.isEmpty()).isTrue();
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
