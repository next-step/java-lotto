import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 테스트")
    void split_shouldContainEachValue() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).contains("1");
    }

    @Test
    @DisplayName("substring 테스트")
    void substring_shouldRemoveBracket() {
        String target = "(1,2)";
        assertThat(target.substring(1,target.length()-1)).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("charAt 테스트")
    @CsvSource(value = {"t:0", "e:1", "s:2", "t:3"}, delimiter = ':')
    void charAt_shouldPickOneCharacter(char c, int index) {
        assertThat("test".charAt(index)).isEqualTo(c);
    }

    @Test
    @DisplayName("charAt StringIndexOutOfBoundsException 테스트")
    void charAt_ShouldBeStringIndexOutOfBoundsException() {
        assertThatThrownBy(()-> "test".charAt(4),"위치값을 벗어난 index를 입력 할 수 없다.").isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
