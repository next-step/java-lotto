package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 2 * 3:5", "1 + 2 * 3 / 4:7"}, delimiter = ':')
    void tokens(String input, int expected) {
        assertThat(Tokenizer.tokens(input).size()).isEqualTo(expected);
    }

    @Test
    void exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            Tokenizer.tokens(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Tokenizer.tokens("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Tokenizer.tokens("1 + 2 -3 # 5");
        });
    }
}