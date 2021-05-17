package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("split 테스트")
    @Test
    void split() {
        String[] a = "1,2".split(",");
        String[] b = "1".split(",");
        assertThat(a).containsExactly("1", "2");
        assertThat(b).containsExactly("1");
    }

    @DisplayName("substring 테스트")
    @Test
    void substring() {
        String before = "(1,2)";
        String after = before.substring(1, before.length() - 1);
        assertThat(after).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드의 파라미터가 글자 길이보다 클 때 익셉션 발생 확인")
    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            String source = "abc";
            source.charAt(source.length() + 1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
