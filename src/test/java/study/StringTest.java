package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리된다.")
    public void split_test() {
        //given
        String input = "1,2";

        //when
        String[] splitedInput = input.split(",");

        //then
        assertThat(splitedInput).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    public void splitOneLength_test() {
        //given
        String input = "1";

        //when
        String[] splitedInput = input.split(",");

        //then
        assertThat(splitedInput).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환한다.")
    public void substring_test() {
        //given
        String input = "(1,2)";

        //when
        String substringInput = input.substring(1, 4);

        //then
        assertThat(substringInput).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource({"153, 2, 3", "1, 0, 1", "342, 2, 2"})
    void chatAt_test(String input, int index, char expectedValue) {
        //when
        char value = input.charAt(index);

        //then
        assertThat(value).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({"153, -1", "1, 2"})
    void chatAt_fail_test(String input, int index) {
        //when
        assertThatThrownBy(
                () -> input.charAt(index)
        ).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
