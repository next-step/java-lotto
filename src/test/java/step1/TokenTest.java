package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TokenTest {

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "a:false", "b:false", "c:false"} , delimiter = ':')
    void isNumber(String input, boolean expected) {
        assertThat(new Token(input).isNumber()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:true", "-:true", "*:true", "/:true", "#:false"}, delimiter = ':')
    void isOperator(String input, boolean expected) {
        assertThat(new Token(input).isOperator()).isEqualTo(expected);
    }

    @Test
    void isPlusOperator() {
        assertThat(new Token("+").isPlusOperator()).isTrue();
        assertThat(new Token("-").isPlusOperator()).isFalse();
    }

    @Test
    void isMinusOperator() {
        assertThat(new Token("-").isMinusOperator()).isTrue();
        assertThat(new Token("+").isMinusOperator()).isFalse();
    }

    @Test
    void isMultiplyOperator() {
        assertThat(new Token("*").isMultiplyOperator()).isTrue();
        assertThat(new Token("/").isMultiplyOperator()).isFalse();
    }

    @Test
    void isDevideOperator() {
        assertThat(new Token("/").isDevideOperator()).isTrue();
        assertThat(new Token("+").isDevideOperator()).isFalse();
    }
}