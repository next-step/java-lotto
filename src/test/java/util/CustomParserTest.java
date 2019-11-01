package util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomParserTest {

    @Test
    void 커스텀_문자로_파싱하기() {
        String customInput = "//;\n1;2;3;4";

        ParseStrategy strategy = new CustomParser();
        strategy.support(customInput);
        List<String> parsedInputs = strategy.parse(customInput);

        assertThat(parsedInputs).contains("1", "2", "3", "4");
    }

}