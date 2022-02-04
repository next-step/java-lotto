package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TokenizerTest {

    @DisplayName("표현식 분할 유효성 검증")
    @Test
    void testSplitExpression() {
        String before = "//;\n1;2;3;4";

        assertThat(Tokenizer.splitExpression(before))
            .isEqualTo(new String[] {"1", "2", "3", "4"});
    }
}
