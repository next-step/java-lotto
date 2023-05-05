package domain;

import static domain.Tokenizer.splitToken;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TokenizerTest {

    @ParameterizedTest(name = "공백에 맞춰 문자열을 분리한다.")
    @CsvSource(value = "안 녕 하 세 요:5", delimiter = ':')
    void separateTest(String userInput, int expected) {
        assertThat(splitToken(userInput).size())
                .isEqualTo(expected);
    }

    @ParameterizedTest(name = "수식을 알맞게 분리한다.")
    @ValueSource(strings = {"4 + 3 - 2 * 4 / 2"})
    void tokenize(String input) {
        assertThat(splitToken(input)).containsExactly("4", "+", "3", "-", "2", "*", "4", "/", "2");
    }
}
