package stringcalculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class InputValueTest {

    @Test
    @DisplayName("입력 받은 식을 쪼개어 숫자 list를 반환한다.")
    void InputSplitter() {
        String input = "1 - 1 + 1 * 1 / 1";
        List<Integer> test = List.of(1, 1, 1, 1, 1);
        InputValue inputValue = new InputValue(input);

        assertAll(
                () -> assertEquals(test.size(), inputValue.getNumbers().size()),
                () -> assertEquals(test, inputValue.getNumbers())
        );
    }

    @Test
    @DisplayName("입력 받은 식을 쪼개어 opeartor를 반환한다.")
    void getOperator() {
        String input = "1 - 1 + 1 * 1 / 1";
        List<String> test = List.of("-", "+", "*", "/");
        InputValue inputValue = new InputValue(input);

        assertAll(
                () -> assertEquals(test.size(), inputValue.getOperators().size()),
                () -> assertEquals(test, inputValue.getOperators())
        );
    }

    @Test
    void if_not_integer_throw_exception() {
        String input = "2.5 + 2.5";
        assertThrows(WrongInputException.class, () -> new InputValue(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"@", "$", "#", "^"})
    @DisplayName("사칙연산과 숫자 외에 문자가 들어오면 예외를 던진다.")
    void if_input_not_allow(String input) {
        assertThrows(WrongInputException.class, () ->
                new InputValue(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", " ", "\n"})
    @DisplayName("공백이 빈 값만 들어오면 예외를 던진다.")
    void if_input_blank(String input) {
        assertThrows(WrongInputException.class, () ->
                new InputValue(input));
    }
}
