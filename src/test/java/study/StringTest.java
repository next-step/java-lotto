package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void split_by_comma() {
        //given
        String str = "1,2";
        String[] expected = {"1", "2"};
        String[] result;

        //when
        result = str.split(",");

        //then
        assertThat(result).containsExactly(expected);
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void split_by_none_comma() {
        //given
        String str = "1";
        String[] expected = {"1"};
        String[] result;

        //when
        result = str.split(",");

        //then
        assertThat(result).containsExactly(expected);
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현한다.")
    void substring() {
        //given
        String input = "(1,2)";
        String expected = "1,2";

        //when
        input = input.substring(input.indexOf("(") + 1);
        input = input.substring(0, input.indexOf(")"));

        //then
        assertEquals(input, expected);
    }
}
