import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    @DisplayName(value = "split 함수가 주어진 문자열 기준으로 배열을 나누는지 검증한다")
    void split(String data) {
        String[] result = data.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName(value = "split 을 실행할 대상이 없는 경우 1개의 element 만 존재한다")
    void splitOneElement() {
        String[] result = "1".split(",");

        assertThat(result).contains("1");
        assertThat(result.length).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "substring의 begin index와 end index 를 사용해 그 사이의 문자열을 추출한다")
    void subString() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName(value = "charAt 을 이용해 'abc' 에서 특정 문자열을 추출한다")
    void charAtTest() {
        String result = "abc";

        assertThat(result.charAt(0)).isEqualTo('a');
        assertThat(result.charAt(1)).isEqualTo('b');
        assertThat(result.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName(value = "요청 index 가 실제 size 를 넘어가는 경우 IndexOutOfBoundException 을 발생시킨다")
    void charAtOutOfBound() {
        String result = "abc";

        assertThatThrownBy(() -> result.charAt(3))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }

}
