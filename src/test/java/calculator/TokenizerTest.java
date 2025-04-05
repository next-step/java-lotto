package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TokenizerTest {

    @Test
    @DisplayName("입력 문자열을 공백 기준으로 토큰 배열로 변환한다")
    void tokenize_valid_input() {
        final Tokens tokens = Tokens.from("2 * 3 + 4");

        assertThat(tokens.getValues()).containsExactly("2", "*", "3", "+", "4");
    }

    @Test
    @DisplayName("입력 문자열 앞뒤 공백은 무시된다")
    void tokenize_delete_blank() {
        final Tokens tokens = Tokens.from("             10 / 2           ");

        assertThat(tokens.getValues()).containsExactly("10", "/", "2");
    }

    @Test
    @DisplayName("토큰 개수가 짝수일 경우 isOddSize는 false를 반환한다")
    void even_number_of_tokens() {
        final Tokens tokens = Tokens.from("2 + 3 -");

        assertThat(tokens.isOddSize()).isFalse();
    }

    @Test
    @DisplayName("null 또는 공백 입력은 예외가 발생한다")
    void null_or_blank_should_throw() {

        assertThatThrownBy(() -> Tokens.from(null)).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT);

        assertThatThrownBy(() -> Tokens.from("  ")).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.INVALID_INPUT);
    }
}
