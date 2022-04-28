package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SplitStringTest {
    @Test
    void split_공백자로_구분() {
        List<String> result = SplitString.split("1 + 3 - 2 * 5 / 2");
        assertThat(result).isEqualTo(List.of("1", "+", "3", "-", "2", "*", "5", "/", "2"));
    }

    @Test
    void split_입력문자열_비어있는_경우() {
        assertThatThrownBy(() -> SplitString.split(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> SplitString.split("")).isInstanceOf(IllegalArgumentException.class);
    }
}