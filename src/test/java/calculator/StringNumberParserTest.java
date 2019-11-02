package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringNumberParserTest {
    @Test
    @DisplayName("문자열을 , 와 : 로 구분한다")
    void parse() {
        String expectedString = "1,2,3";
        List<Integer> number = StringNumberParser.parse(expectedString);
        assertThat(number).hasSize(3);
    }
}
