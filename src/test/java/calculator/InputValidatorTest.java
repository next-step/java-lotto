package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈_문자열이거나_공백으로_구성된_문자열이면_예외_발생(String input) {
        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(input))
                        .withMessageMatching("빈 문자열이나 공백으로 구성된 문자열은 허용되지 않습니다");
    }

    @Test
    void 숫자_사칙연산자_공백문자_이외의_문자_포함되어있으면_예외_발생() {
        // given
        String input = "1 + 2 ! 3";

        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(input))
                .withMessage("숫자, 사칙연산자(+, -, *, /), 공백 이외의 문자는 허용되지 않습니다");
    }

    @Test
    void 숫자_사칙연산자_사이_공백문자_없으면_예외_발생() {
        // given
        List<String> inputItems = List.of("10+", "1");

        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(inputItems))
                .withMessage("숫자, 사칙연산자(+, -, *, /) 사이에는 공백이 있어야 합니다");
    }
}
