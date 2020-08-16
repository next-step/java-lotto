import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("구분자로 값을 분리하여 반환")
    @Test
    void splitValuesWithDelimiter() {
        String value = "//;\n1;2";
        String expression = value.replaceAll("//;\n", "");
        Delimiter delimiter = Delimiter.newInstance(value);

        //when
        ExpressionNumbers actual = delimiter.splitValue(expression);

        //then
        String[] numberValues = {"1", "2"};
        ExpressionNumbers expected = ExpressionNumbers.newInstance(numberValues);

        assertEquals(expected, actual);
    }
}
