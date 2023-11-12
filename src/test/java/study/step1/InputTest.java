package study.step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step1.domain.dto.Input;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static study.step1.view.InputParser.parse;

public class InputTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "1+2/3"
    })
    void 입력값이_공백으로_구분되어_있지_않음(String string) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Input(parse(string)))
            .withMessage("InputError: 입력값 오류(공백 구분 없음)");
    }


    @Test
    void 문자열_공백_구분_없이_입력() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Input(parse("1+2/3")))
            .withMessage("InputError: 입력값 오류(공백 구분 없음)");
    }

    @ParameterizedTest(name = ": {0}")
    @ValueSource(strings = {
        "a + 2 / 3",
        "1 + 2 + +",
        "1 + 2+ 3",

    })
    void 숫자가_아닌_문자_입력(String string) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Input(parse(string)))
            .withMessage("InputError: 입력값 오류(숫자가 아닌 값)");
    }

    @ParameterizedTest(name = ": {0}")
    @ValueSource(strings = {
        "1 + 2 = 3",
        "1 $ 2 + 3",

    })
    void 사칙연산_기호가_아닌_문자_입력(String string) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Input(parse(string)))
            .withMessage("InputError: 입력값 오류(사칙연산 기호가 아닌 값)");
    }
}
