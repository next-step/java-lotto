package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SeparatorTest {

    @Test
    void 문자열에서_커스텀_구분자를_추출함() {
        Separator separator = new Separator();
        String userInput = "//.\n1.2.3.4";
        assertThat(separator.extractCustomDelimiter(userInput)).isEqualTo(".");
    }

}