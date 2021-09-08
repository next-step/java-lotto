package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {
    @Test
    @DisplayName("당첨번호 문자열을 숫자로 파싱하는지 테스트")
    void parseStringNumbers() {
        List<Integer> numbers = StringParser.parseIntList("1,2,3,4,5,6");
        assertThat(numbers).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}