package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TokensTest {

    @Test
    void sum() {
        Token[] values = new Token[] {
                new Token("1"),
                new Token("2")
        };
        Tokens tokens = new Tokens(values);
        int result = tokens.sum();
        assertThat(result).isEqualTo(3);
    }

}
