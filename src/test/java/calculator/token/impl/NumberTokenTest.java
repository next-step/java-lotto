package calculator.token.impl;

import calculator.token.Token;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTokenTest {

    @DisplayName("숫자로 변환한다.")
    @Test
    void getValue() {
        Token token = new NumberToken("10");
        assertThat(((NumberToken) token).getValue()).isEqualTo(10);
    }

    @DisplayName("숫자 토큰은 isOperator false를 반환한다.")
    @Test
    void isOperator() {
        Token token = new NumberToken("10");
        assertThat(token.isOperator()).isFalse();
    }

    @DisplayName("숫자가 아니면 exception을 반환한다.")
    @Test
    void exception() {
        assertThatThrownBy(() -> new NumberToken("abc"))
                .isInstanceOf(NumberFormatException.class);
    }
}
