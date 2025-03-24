package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TokensTest {

    @DisplayName("빈 문자열일 경우 IllegalArgumentException 발생")
    @Test
    void emptyStringTest() {
        // When & Then
        assertThatThrownBy(() -> new Tokens(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid String");
    }

    @DisplayName("null일 경우 IllegalArgumentException 발생")
    @Test
    void nullStringTest() {
        // When & Then
        assertThatThrownBy(() -> new Tokens(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid String");
    }

}