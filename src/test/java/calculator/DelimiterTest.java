package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterTest {

    @DisplayName("기본 구분자 생성")
    @Test
    void create_default() {
        //given
        String value = "1:2,3";
        Delimiter delimiter = new Delimiter(value);

        //when
        List<Number> numbers = delimiter.numbers(value);

        //then
        assertEquals(numbers.size(), 3);
    }

    @DisplayName("사용자 구분자 생성")
    @Test
    void create_custom() {
        //given
        String value = "//;\n1;2;3";
        Delimiter delimiter = new Delimiter(value);

        //when
        List<Number> numbers = delimiter.numbers(value);

        //then
        assertThat(numbers.size()).isEqualTo(3);
    }
}
