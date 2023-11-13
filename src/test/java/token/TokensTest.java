package token;

import number.Number;
import operator.Operation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TokensTest {

    @Test
    @DisplayName("공백으로 문자열을 분리한다.")
    void token_get() {
        List<String> list = Arrays.asList("1", "+", "2", "-", "3", "*", "4", "/", "5");
        Tokens tokens = Tokens.from(list);

        Assertions.assertThat(tokens.number()).isEqualTo(Number.from("1"));
        Assertions.assertThat(tokens.operation()).isEqualTo(Operation.from("+"));
        Assertions.assertThat(tokens.number()).isEqualTo(Number.from("2"));
        Assertions.assertThat(tokens.operation()).isEqualTo(Operation.from("-"));
        Assertions.assertThat(tokens.number()).isEqualTo(Number.from("3"));
        Assertions.assertThat(tokens.operation()).isEqualTo(Operation.from("*"));
        Assertions.assertThat(tokens.number()).isEqualTo(Number.from("4"));
        Assertions.assertThat(tokens.operation()).isEqualTo(Operation.from("/"));
        Assertions.assertThat(tokens.number()).isEqualTo(Number.from("5"));
    }
}