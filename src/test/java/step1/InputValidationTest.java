package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    private static final String DELIMITER = " ";

    @DisplayName("공백으로 분리된 문자열 배열의 요소가 공백이면 예외를 던진다.")
    @Test
    void splitByBlankWhenElementIsBlank() {
        // given
        InputValidation inputValidation = new InputValidation();
        String input = "2 + 3 *   / 2";
        String[] numAndSymbols = input.split(DELIMITER);

        // when & then
        assertThatThrownBy(() -> inputValidation.validate(numAndSymbols)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자, 연산 기호 자리에는 공백이 입력될 수 없습니다.");
    }

    @DisplayName("입력된 문자열을 공백으로 분리 후 숫자의 값이 실수가 아니면 예외를 던진다.")
    @Test
    void splitByBlankWhenStringIsNotRealNumber() {
        // given
        InputValidation inputValidation = new InputValidation();
        String input = "2 + 3 * string / 2";
        String[] numAndSymbols = input.split(DELIMITER);

        // when & then
        assertThatThrownBy(() -> inputValidation.validate(numAndSymbols)).isInstanceOf(NumberFormatException.class)
            .hasMessage("숫자 자리에는 실수만 입력 가능합니다.");
    }

    @DisplayName("입력된 문자열을 공백으로 분리 후 연산기호의 값이 (+,-,*,/)이 아니면 예외를 던진다.")
    @Test
    void splitByBlankWhenStringIsNotSymbols() {
        // given
        InputValidation inputValidation = new InputValidation();
        String input = "2 + 3 : 5 / 2";
        String[] numAndSymbols = input.split(DELIMITER);

        // when & then
        assertThatThrownBy(() -> inputValidation.validate(numAndSymbols)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("연산기호는 (+, -, *, /)만 가능합니다.");
    }
}