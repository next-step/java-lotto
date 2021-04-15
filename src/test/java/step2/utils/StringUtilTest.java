package step2.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    @DisplayName("List타입을 형식에 맞춰 문자열로 변환하는 유틸 테스트")
    void splitStringFromList() {
        // given
        List<Integer> given = Arrays.asList(1,2,3,4,5,6);
        String expected = "[1, 2, 3, 4, 5, 6]";
        // when
        String actual = StringUtil.splitStringFromList(given);

        // then
        assertEquals(expected, actual);
    }
}
