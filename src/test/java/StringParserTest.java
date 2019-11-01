import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {

    @Test
    void 쉼표와_콜론을_기준으로_문자열_분리() {
        String normalInput = "1:2,3";
        List<Integer> parsedInputs = StringParser.parse(normalInput);
        assertThat(parsedInputs).contains(1, 2, 3);
    }

    @Test
    void 커스텀_구분자_추가해서_문자열분리() {
        String customInput = "//;\n1,2:3;4";
        List<Integer> parsedInputs = StringParser.parse(customInput);
        assertThat(parsedInputs).contains(1, 2, 3, 4);
    }
}
