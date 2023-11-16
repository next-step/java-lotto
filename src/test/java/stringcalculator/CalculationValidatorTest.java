package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculationValidatorTest {

    @DisplayName("인자로 받은 문자열 배열의 요소가 공백이면 예외를 던진다.")
    @Test
    void splitByBlankWhenElementIsBlank() {
        // given
        String[] numAndSymbols = {"2","+","3","*"," ","/","2"};

        // when & then
        assertThatThrownBy(() -> CalculationValidator.validate(numAndSymbols)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자, 연산 기호 자리에는 공백이 입력될 수 없습니다.");
    }

    @DisplayName("인자로 받은 문자열 배열의 숫자 자리의 값이 실수가 아니면 예외를 던진다.")
    @Test
    void splitByBlankWhenStringIsNotRealNumber() {
        // given
        String[] numAndSymbols = {"2","+","3","*","string","/","2"};

        // when & then
        assertThatThrownBy(() -> CalculationValidator.validate(numAndSymbols)).isInstanceOf(NumberFormatException.class)
            .hasMessage("숫자 자리에는 실수만 입력 가능합니다.");
    }

    @DisplayName("인자로 받은 문자열 배열의 연산기호 자리의 값이 (+,-,*,/)이 아니면 예외를 던진다.")
    @Test
    void splitByBlankWhenStringIsNotSymbols() {
        // given
        String[] numAndSymbols = {"2","+","3",":","5","/","2"};

        // when & then
        assertThatThrownBy(() -> CalculationValidator.validate(numAndSymbols)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("연산기호는 (+, -, *, /)만 가능합니다.");
    }
}