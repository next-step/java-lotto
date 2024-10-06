package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

class InputValidatorTest {
    @Test
    void 유효성_검사_통과() {
        // given
        String input = "1 + 2 * 3 / 4 - 5";

        // when, then
        InputValidator.validate(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈_문자열이거나_공백으로_구성된_문자열이면_예외_발생(String input) {
        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(input))
                .withMessageMatching("빈 문자열이나 공백으로 구성된 문자열은 허용되지 않습니다");
    }

    static Stream<List<String>> makeSequentialItem() {
        return Stream.of(
                List.of("1", "-", "+"),
                List.of("1", "2", "+")
        );
    }

    @Test
    void 숫자_사칙연산자_공백문자_이외의_문자_포함되어있으면_예외_발생() {
        // given
        String input = "1 + 2 ! 3";

        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(input))
                .withMessage("숫자, 사칙연산자(+, -, *, /), 공백 이외의 문자는 허용되지 않습니다");
    }
}
