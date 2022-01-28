package stringadder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringadder.utils.exception.StringUtils;

public class AdderTest {

    @DisplayName("쉼표_콜론_기준으로_문자열구분")
    @Test
    void stringSplitTest() {
           String input = "1,2:3";
           List<String> parsingInput = StringUtils.splitStr(input);
           assertAll(
               ()->assertThat(parsingInput.get(0)).isEqualTo("1"),
               ()->assertThat(parsingInput.get(1)).isEqualTo("2"),
               ()->assertThat(parsingInput.get(2)).isEqualTo("3")
           );
    }

}
