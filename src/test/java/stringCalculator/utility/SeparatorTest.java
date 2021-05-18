package stringCalculator.utility;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SeparatorTest {
    Separator separator;

    @BeforeEach
    void setup() {
        separator = new Separator();
    }

    @Test
    @DisplayName("문자를 , 구분자로 자르기")
    void testSplitComma() {
        //given
        String[] result = separator.splitNumber("1,2", ",");
        //when
        //then
        assertThat(getLength(result)).isEqualTo(2);
    }

    @Test
    @DisplayName("문자를 : 구분자로 자르기")
    void testSplitColon() {
        //given
        String[] result = separator.splitNumber("1:2", ":");
        //when
        //then
        assertThat(getLength(result)).isEqualTo(2);
    }

    @Test
    @DisplayName("문자 분리 실패")
    void testSplitFail() {
        //given
        String[] result = separator.splitNumber("1:2", ",");
        //when
        //then
        assertThat(getLength(result)).isNotEqualTo(2);
    }

    private int getLength(String[] param) {
        return param.length;
    }
}