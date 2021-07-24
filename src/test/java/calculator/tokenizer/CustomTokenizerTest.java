package calculator.tokenizer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomTokenizerTest {
    private CustomTokenizer tokenizer = new CustomTokenizer();

    @Test
    @DisplayName("정상적인 값이 입력되면 문자열이 정상적으로 분리된다")
    void tokenize() throws Exception {
        String[] strings = tokenizer.tokenize("//;\n1;2;3");
        assertThat(strings).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 토큰이 -이면 예외가 발생한다")
    void tokenize_exception_v1() throws Exception {
        assertThatThrownBy(() -> tokenizer.tokenize("//-\n1-2-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Token not found.");
    }

    @Test
    @DisplayName("커스텀 토큰이 숫자이면 예외가 발생한다")
    void tokenize_exception_v2() throws Exception {
        assertThatThrownBy(() -> tokenizer.tokenize("//3\n1-2-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Token not found.");
    }

    @Test
    @DisplayName("입력 문자열이 커스텀 토큰을 포함하면 참을 반환한다")
    void isCustomExpression() throws Exception{
        boolean actual = tokenizer.isCustomExpression("//;\n1;2;3");
        Assertions.assertThat(actual).isTrue();
    }
}
