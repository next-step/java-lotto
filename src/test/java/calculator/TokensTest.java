package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TokensTest {
    @Test
    @DisplayName("정상 수식을 올바르게 계산한다")
    void value() {
        Tokens tokens = Tokens.from("2 + 3 * 4 / 2");

        PositiveNumber result = tokens.value();

        assertThat(result.toInt()).isEqualTo(10);
    }

    @Test
    @DisplayName("토큰이 비어 있으면 IllegalArgumentException")
    void emptyTokens() {
        assertThatThrownBy(() -> Tokens.from("   "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("토큰 개수가 짝수이면 IllegalArgumentException")
    void evenTokenCount() {
        assertThatThrownBy(() -> Tokens.from("2 +"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
