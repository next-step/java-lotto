package step1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TokenizerTest {

    @Test
    void tokenizerTest() {
        String inputValue = "//;\n1;2;3";
        Tokenizer tokenizer = new Tokenizer();
        assertThat(tokenizer.splitValue(inputValue).length).isEqualTo(3);

        inputValue = "1,2,3;4;5";
        assertThat(tokenizer.splitValue(inputValue).length).isEqualTo(5);
    }
}
