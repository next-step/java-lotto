package util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultParserTest {

    @Test
    void 기본문자열_입력_파싱하기() {
        String normalInput = "1:2,3";

        ParseStrategy strategy = new DefaultParser();
        strategy.support(normalInput);
        List<String> parsedInputs = strategy.parse();

        assertThat(parsedInputs).contains("1", "2", "3");
    }

}