package step1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TokenizerTest {

    @Test
    void tokenizerDefaultTest() {
        String[] inputValueList = {"1", "2", "3"};
        String inputValue = inputValueList[0] + "," + inputValueList[1] + ";" + inputValueList[2];
        Tokenizer tokenizer = new Tokenizer();
        String[] valueList = tokenizer.splitValue(inputValue);
        assertThat(valueList.length).isEqualTo(3);

        for (int i = 0; i<inputValueList.length; i++) {
            assertThat(inputValueList[i].equals(valueList[i])).isEqualTo(true);
        }
    }

    @Test
    void tokenizerChangedTest() {
        String inputValue = "//;\n1;2;3";
        Tokenizer tokenizer = new Tokenizer();
        assertThat(tokenizer.splitValue(inputValue).length).isEqualTo(3);
    }
}
