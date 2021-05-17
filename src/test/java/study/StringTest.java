package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @DisplayName("\"1,2\"를 ,로 분할하면 1과 2로 분리된 배열이 반환된다")
    @Test
    void check_split_contains() {
        // given
        String value = "1,2";

        // when
        String[] result = value.split(",");

        // then
        assertThat(result).contains("1", "2");
    }

    @DisplayName("\"1\"을 ,로 분할하면 1만을 포함하는 배열이 반환된다")
    @Test
    void check_split_containsExactly() {
        // given
        String value = "1";

        // when
        String[] result = value.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @DisplayName("substring() 이용 양쪽 괄호를 제거하면 괄호가 제거된 문자가 반환된다")
    @Test
    void substring_parenthesis_remove() {
        // given
        String value = "(1,2)";
        int beginIndex = value.indexOf("(") + 1;
        int endIndex = value.indexOf(")");

        // when
        String result = value.substring(beginIndex, endIndex);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("범위를 초과하는 위치값의 문자를 가져오면 예외가 발생한다")
    @Test
    void charAt_indexOutOfBoundsException() {
        // given
        String value = "abc";

        // when

        // then
        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
