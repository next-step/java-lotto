import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValueTest {
    @Test
    @DisplayName("입력 받은 식을 쪼갠다")
    void InputSplitter() {
        String input = "1 - 1 + 1 * 1 / 1";
        String[] test = input.split(" ");
        InputValue inputValue = new InputValue(input);
        assertThat(inputValue.hasSize(test.length)).isTrue();
    }

    @Test
    @DisplayName("사칙연산과 숫자외에 문자가 들어오면 예외를 던진다.")
    void if_input_not_allow() {
        String input = "1 $ 2";

        assertThrows(IllegalArgumentException.class, () ->
                new InputValue(input));
    }
}
