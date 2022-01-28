package stringadder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringadder.utils.exception.StringUtils;

public class AdderTest {

    @DisplayName("쉼표_콜론_기준으로_문자열구분")
    @ParameterizedTest
    @ValueSource(strings={"1,2:3","//;\n1;2;3","//-\n1-2-3"})
    void stringSplitTest(String input) {
          List<String> parsingInput = StringUtils.splitStr(input);
           assertAll(
               ()->assertThat(parsingInput.get(0)).isEqualTo("1"),
               ()->assertThat(parsingInput.get(1)).isEqualTo("2"),
               ()->assertThat(parsingInput.get(2)).isEqualTo("3")
           );
    }

}
