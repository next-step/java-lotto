package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 입력문자열이_null이거나_공백일경우_예외를_던진다(String input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Word(input)
        );
    }

    @Test
    void 공백_문자열을_기준으로_split한다() {
        final var word = new Word("2 + 3 * 4 / 2");

        final var words = word.split(" ");

        assertThat(words).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

}