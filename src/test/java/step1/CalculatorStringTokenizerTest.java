package step1;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStringTokenizerTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "1,2:3",
        "//;\n1;2;3"
    })
    @DisplayName("ok")
    void split(String input) {
        List<String> tokens = CalculatorStringTokenizerFactory.createTokenizer(input)
                                                               .split();
        assertThat(tokens.get(0)).isEqualTo("1");
        assertThat(tokens.get(1)).isEqualTo("2");
        assertThat(tokens.get(2)).isEqualTo("3");
    }

}
