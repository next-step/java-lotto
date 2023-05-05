package domain;

import static domain.Tokenizer.splitToken;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TokenizerTest {

    @ParameterizedTest(name = "공백에 맞춰 문자열을 분리한다.")
    @CsvSource(value = "안 녕 하 세 요:5", delimiter = ':')
    void separateTest(String userInput, int expected) {
        assertThat(splitToken(userInput).size())
                .isEqualTo(expected);
    }
}
