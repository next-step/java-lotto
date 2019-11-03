package step1.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParserGroupTest {

    @Test
    void findStrategyByInput_기본형식() {
        String normal = "1,2:3";

        ParseStrategy strategy = ParserGroup.findStrategyByInput(normal);

        assertThat(strategy).isEqualTo(ParserGroup.DEFAULT.getParseStrategy());
    }

    @Test
    void findStrategyByInput_커스텀형식() {
        String custom = "//;\n1;2;3";

        ParseStrategy strategy = ParserGroup.findStrategyByInput(custom);

        assertThat(strategy).isEqualTo(ParserGroup.CUSTOM.getParseStrategy());
    }
}