package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitterTest {

    private final Splitter splitter = new Splitter();

    @Test
    void split() {
        assertThat(splitter.split("")).containsExactly("");
        assertThatThrownBy(() -> {
            splitter.split(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("text는 null일 수 없습니다.");
        assertThat(splitter.split("1,2")).containsExactly("1", "2");
        assertThat(splitter.split("1,2,3")).containsExactly("1", "2", "3");
        assertThat(splitter.split("1,2:3")).containsExactly("1", "2", "3");
        assertThat(splitter.split("//;\n1;2;3")).containsExactly("1", "2", "3");
        assertThat(splitter.split("//;\n1,2:3;4")).containsExactly("1", "2", "3", "4");
        assertThat(splitter.split("//-\n1-2")).containsExactly("1", "2");
    }

}
