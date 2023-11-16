package calculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class SplitterTest {


    @Test
    @DisplayName("공백으로 문자열을 분리한다")
    void split() {
        List<String> splitter = Splitter.splitter("1 + 2 - 3 * 4 / 5", Splitter.BLANK);
        Assertions.assertThat(splitter).containsExactly("1", "+", "2", "-", "3", "*", "4", "/", "5");
    }

}