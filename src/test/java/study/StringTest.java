package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("split 메서드 성공")
    void testSplitSuccess() {
        //given
        String input = "1,2";
        //when
        String[] splitInput = input.split(",");
        //then
        assertThat(splitInput.length).isEqualTo(2);
        assertThat(splitInput).contains("1");
        assertThat(splitInput).contains("2");
        assertThat(splitInput).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring 메서드 성공")
    void testSubString() {
        //given
        String input = "(1,2)";
        //when
        String output = input.substring(1, 4);
        //then
        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메서드 성공")
    void testCharAtSuccess() {
        //given
        String input = "abc";
        //when
        char firstIndex = input.charAt(0);
        char secondIndex = input.charAt(1);
        char thirdIndex = input.charAt(2);
        //then
        assertThat(firstIndex).isEqualTo('a');
        assertThat(secondIndex).isEqualTo('b');
        assertThat(thirdIndex).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메서드 실패 - input의 length 보다 큰 값의 index를 지정한 경우")
    void testCharAtFailed() {
        //given
        String input = "abc";
        int index = 3;
        //when
        assertThatThrownBy(() -> {
            input.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    input.charAt(index);
                }).withMessageContaining("index out of range");
        //then
    }
}