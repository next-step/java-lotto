import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TokenizerTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"})
    public void splitTest() {
        String message = "1,2:3";
        List<Integer> tokens = Tokenizer.split(message);
        assertThat(tokens).hasSize(3);
        assertThat(tokens).contains(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1@2,3", "1!2:3", "1!2!3", "1@2@3"})
    public void withWrongMessageSplitThrowException(String message) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Tokenizer.split(message);
        });
    }

    @Test
    public void customDelimiterSplitTest() {
        String message = "1;2;3";
        String delimiter = ";";
        List<Integer> tokens = Tokenizer.split(message, delimiter);
        assertThat(tokens).hasSize(3);
        assertThat(tokens).contains(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"@", "!", "#", ";"})
    public void withWrongDelimiterSplitThrowException(String delimiter) {
        String message = "1,2:3";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Tokenizer.split(message, delimiter);
        });
    }


}
