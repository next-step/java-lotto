package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputSplitterTest {

    @Test
    @DisplayName("','를 기준으로 split 처리한다.")
    void split_comma() {
        assertThat(InputSplitter.split("1,2,3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("':'를 기준으로 split 처리한다.")
    void split_colon() {
        assertThat(InputSplitter.split("1:2:3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("','와 ':'를 기준으로 split 처리한다.")
    void split_comma_and_colon() {
        assertThat(InputSplitter.split("1,2:3")).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("custom 구분자를 기준으로 split 처리한다.")
    void split_custom_delimiter() {
        assertThat(InputSplitter.split("//;\n1;2;3")).containsExactly("1", "2", "3");
    }
}
