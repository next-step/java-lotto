import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DelimiterTest {
    @DisplayName("객체생성 - 사용자 정의 구분자가 있는 경우")
    @Test
    void newInstanceWithCustomDelimiter() {
        //given
        String expression = "//?\n1?2";
        String expectedDelimiter = "//?\n";
        //when
        Delimiter actual = Delimiter.newInstance(expression);

        //then
        Delimiter expected = Delimiter.newInstance(expectedDelimiter);
        assertEquals(expected, actual);
    }

    @DisplayName("객체생성 - 사용자 정의 구분자가 없는 경우")
    @Test
    void newInstanceWithDefaultDelimiter() {
        //given
        String expression = "1?2";
        String expectedDelimiter = "[,;]";

        //when
        Delimiter actual = Delimiter.newInstance(expression);

        //then
        Delimiter expected = Delimiter.newInstance(expectedDelimiter);
        assertEquals(expected, actual);
    }
}
