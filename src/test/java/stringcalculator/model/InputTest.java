package stringcalculator.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringcalculator.model.Input.*;

public class InputTest {
    @Test
    void 입력문자열을_잘라_저장한다() {
        String input = "2 + 3 * 4 / 2";
        Input actual = new Input(input);
        Input expected = Input.of(new String[]{"2", "+", "3", "*", "4", "/", "2"});
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 입력문자열_size_는_홀수가_아니면_예외처리한다() {
        assertThatThrownBy(() -> {
            String input = "2 + 3 * 4 / ";
            new Input(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ALLOW_BELOW_THREE_OR_LIST_SIZE_EVEN_NUMBER);
    }
}
