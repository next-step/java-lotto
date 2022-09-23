package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class TokenizerTest {

    @DisplayName("문자열을 공백 기준으로 나눠 반환한다")
    @Test
    void input() {
        Queue<String> tokens = new Tokenizer(" ").queue("2 + 3 * 4 / 2");

        assertThat(tokens).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }
}