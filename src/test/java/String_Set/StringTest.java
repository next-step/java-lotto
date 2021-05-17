package String_Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1-1 -문자열 '1,2'를 ,으로 split 했을때 문자열이 잘 분리되는지 테스트")
    void testSplit_1() {
        String input = "1,2";

        String[] splited = input.split(",");

        assertThat(splited).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항1-2 - 문자열 '1'을 , 으로 split했을때 1만을 포함하는 배열이 반환되는지 테스트")
    void testSplit_2() {
        String input = "1";

        String[] splited = input.split(",");

        assertThat(splited).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 - '(1,2)' 값이 주어졌을때, substring으로 괄호를 제거하고 숫자만 반환하는지 테스트")
    void testSubstring() {
        String input = "(1,2)";

        String numbers = input.substring(1, input.length() - 1);

        assertThat(numbers).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3-1 - 'abc' 값이 주어졌을 때 charAt() 메소드를 통해 특정 위치 문자 가져오기 테스트")
    void testCharAt() {
        String input = "abc";

        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);

        assertThat(first).isEqualTo('a');
        assertThat(second).isEqualTo('b');
        assertThat(third).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항3-2 - 요구사항 3-1에서 특정 문자열의 위치 값 지정시 문자열 길이를 벗어날 경우 예외 발생 테스트")
    void testCharAt_Exception() {
        String input = "abc";
        int overIndex = input.length();

        assertThatThrownBy(() -> input.charAt(overIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: "+overIndex);
    }
}
