package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SeparatorTest {

    @Test
    void 문자열에서_커스텀_구분자를_추출함() {
        Separator separator = new Separator();
        String userInput = "//.\n1.2.3.4";
        assertThat(separator.extractCustomDelimiter(userInput)).isEqualTo(".");
    }

//    @Test
//    void 커스텀_구분자를_포함하여_문자열을_분리() {
//        Separator separator = new Separator();
//        String userInput = "//.\n1.2;3,4";
//        String customDelimiter = separator.extractCustomDelimiter(userInput);
//        Number number = new Number(userInput);
//        assertThat(number.split()).isEqualTo(Arrays.asList("1", "2", "3", "4"));
//    }

    @DisplayName("사용자 입력으로 들어온 문자열에서 콤마(,),콜론(:)을 제거")
    @ParameterizedTest
    @ValueSource(strings = {"123,456:789.10"})
    void 사용자_입력으로_들어온_문자열에서_콤마_콜론_을_기준으로_자름(final String userInput) {
        Number number = new Number(userInput);
        Separator separator = new Separator();
        assertThat(separator.split(number.getNumber(), "\\."))
            .isEqualTo(Arrays.asList("123", "456", "789", "10"));
    }
}