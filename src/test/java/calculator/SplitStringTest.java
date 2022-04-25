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

    @Test
    void invalid_입력문자열_숫자로_시작_안하는_경우() {
        assertThatThrownBy(() -> SplitString.split("+ 3 - 1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid_입력문자열_사칙연산_기호가_아닌_경우() {
        assertThatThrownBy(() -> SplitString.split("1 + 3 % 1")).isInstanceOf(IllegalArgumentException.class);
    }
}