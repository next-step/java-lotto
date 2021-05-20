package warmup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("String split 테스트")
    void split() {
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("String substring 테스트")
    void substring() {
        String data = "(1,2)";
        assertThat(data.substring(1, data.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String charAt 테스트")
    void charAt() {
        String data = "abc";
        assertThatThrownBy(()-> data.charAt(-1)).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("index", "-1");
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(2)).isEqualTo('c');
        assertThatThrownBy(()->data.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("index","3");
    }
}
