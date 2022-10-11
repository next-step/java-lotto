package stringcalculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputVerifierTest {

    @ParameterizedTest
    @ValueSource(strings = {"@", "$", "#", "^"})
    @DisplayName("사칙연산과 숫자 외에 문자가 들어오면 예외를 던진다.")
    void if_input_not_allow(String input) {
        assertThrows(WrongInputException.class, () ->
                InputVerifier.validateInput(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", " ", "\n"})
    @DisplayName("공백이 빈 값만 들어오면 예외를 던진다.")
    void if_input_blank(String input) {
        assertThrows(WrongInputException.class, () ->
                InputVerifier.validateInput(input));
    }
    @ParameterizedTest
    @ValueSource(strings = {"1 + 1 + 1 +"})
    @DisplayName("공백이 빈 값만 들어오면 예외를 던진다.")
    void if_input(String input) {
        assertThrows(WrongInputException.class, () ->
                InputVerifier.validateInput(input));
    }
}