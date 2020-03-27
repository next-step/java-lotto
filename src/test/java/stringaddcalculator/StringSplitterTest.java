package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringSplitterTest {
    @DisplayName("StringSplitter는 쉼표 구분자로 문자열을 분리해서 리턴한다.")
    @Test
    void splitTest() {
        assertThat(StringSplitter.split("1,2,3")).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @DisplayName("StringSpltter는 콜론 구분자로 문자열ㅇ르 분리해서 리턴한다.")
    @Test
    void splitTest2() {
        assertThat(StringSplitter.split("1:2:3")).isEqualTo(Arrays.asList("1", "2", "3"));
    }
}