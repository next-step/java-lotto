package calculator.util;

import calculator.util.UserInputHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputHandlerTest {
    @ParameterizedTest
    @ValueSource(strings = {"1 + a", "1 + ~", "a   ", "1  "})
    void 빈공백으로_나눠서_숫자_연산자를_제외한_문자가_들어오면_예외가_발생(String input) {
        assertThat(UserInputHandler.checkValidate(input)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 입력값이_null이거나_빈공백문자일_경우_예외가_발생(String input) {
        assertThat(UserInputHandler.checkValidate(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 1 1,false", "1 a +,false", "1 + 1,true"})
    void 숫자_빈_공백이후에는_사칙연산이_나와야한다(String input, boolean expected) {
        assertThat(UserInputHandler.checkValidate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"abcd,false", "2 + 3 * 4 / 2,true", "2+3*4/2,false", "1,false", "2+3 * 4/2,false"})
    void 띄어쓰기가_없으면_예외가_발생(String input, boolean expected) {
        assertThat(UserInputHandler.checkValidate(input)).isEqualTo(expected);
    }
}
