package step2.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTest {

    @Test
    @DisplayName("List를 문자열로 변환하는 테스트")
    void name() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        String expected = "[1, 2, 3, 4, 5, 6]";

        // when
        String actual = StringUtil.splitStringFromList(lottoNumbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("double형 타입 두자릿수까지 출력되는지 테스트")
    void splitDouble() {
        // given
        double given = 3.6666;
        double expected = 3.67;

        // when
        double actual = StringUtil.splitDouble(given);

        // then
        assertEquals(expected, actual);
    }
}
