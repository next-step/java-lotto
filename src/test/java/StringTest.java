import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split했을 때 분리가 되는지 검증한다.")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 ()을 제거하고 1,2를 반환한다.")
    void splitRemove() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException을 리턴한다.")
    void charAtTest() {
        char charValue = "abc".charAt(1);

        assertThat(charValue).isEqualTo('b');
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(IndexOutOfBoundsException.class);
    }

}