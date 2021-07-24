package calculator.tokenizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultTokenizerTest {
    private Tokenizer tokenizer = new Tokenizer();

    /**
     * 요구사항에 정의 된 기본 토큰은 쉼표(,)와 콜론(:)이다.
     */
    @Test
    @DisplayName("정상 입력 시 기본 토큰으로 문자열을 분리한다")
    void tokenize() throws Exception {
        String[] strings = tokenizer.tokenize("1,2:3");
        assertThat(strings).containsExactly("1", "2", "3");
    }
}
