import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValueTest {

    @Test
    @DisplayName("입력 받은 식을 쪼개어 list로 반환한다.")
    void InputSplitter() {
        String input = "1 - 1 + 1 * 1 / 1";
        List<String> test = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        InputValue inputValue = new InputValue(input);

        assertThat(inputValue.hasSize(test.size())).isTrue();
        assertThat(inputValue.getExpression()).isEqualTo(test);
    }

    @ParameterizedTest
    @ValueSource(strings = {"@", "$", "#", "^"})
    @DisplayName("사칙연산과 숫자 외에 문자가 들어오면 예외를 던진다.")
    void if_input_not_allow(String input) {
        assertThrows(IllegalArgumentException.class, () ->
                new InputValue(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", "\t", "\n"})
    @DisplayName("공백이 빈 값이 들어오면 예외를 던진다.")
    void if_input_blank(String input) {
        assertThrows(IllegalArgumentException.class, () ->
                new InputValue(input));
    }
}
