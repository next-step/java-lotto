package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TokenizerTest {
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void tokenize(String input) {
        assertThat(Tokenizer.tokenize(input)).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }
}
