import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TokenizerTest {

    @Test
    void tokenizerTest(){
        String inputValue = "1~2~3~4";
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.changeSplitValue("~");
        assertThat(tokenizer.splitValue(inputValue).length).isEqualTo(4);
    }

    @Test
    void defaultTokenizerTest(){
        String inputValue = "1,2,3;4;5";
        Tokenizer tokenizer = new Tokenizer();

        AssertionsForClassTypes.assertThat(tokenizer.splitValue(inputValue).length).isEqualTo(5);
    }


}
