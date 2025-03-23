package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class TokenizerTest {
    @Test
    @DisplayName("2 + 3 = [2, +, 3]")
    void tokenize() {
        String input = "2 + 3";
        List<String> tokens = Tokenizer.tokenize(input);
        Assertions.assertThat(tokens).containsExactly("2", "+", "3");
    }

    @ParameterizedTest(name = "공백 미포함시 예외 발생")
    @ValueSource(strings = {"2+3", " 2+3", "2+3 "})
    void validate(String input) {
        Assertions.assertThatThrownBy(() -> Tokenizer.tokenize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 기준으로 입력해주세요.");
    }
}
