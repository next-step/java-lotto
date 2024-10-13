package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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

    @Test
    void 숫자_사칙연산자_공백문자_이외의_문자_포함되어있으면_예외_발생() {
        // given
        String input = "1 + 2 ! 3";

        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(input))
                .withMessage("숫자, 사칙연산자(+, -, *, /), 공백 이외의 문자는 허용되지 않습니다");
    }

    @Test
    void 가장_처음_문자가_숫자가_아니면_예외_발생() {
        // given
        List<String> inputItems = List.of("*", "10");

        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(inputItems))
                .withMessage("가장 첫 항목은 숫자이어야 합니다");
    }

    @Test
    void 숫자_사칙연산자_사이_공백문자_없으면_예외_발생() {
        // given
        List<String> inputItems = List.of("10", "+1");

        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(inputItems))
                .withMessage("숫자, 사칙연산자(+, -, *, /) 사이에는 공백이 있어야 합니다");
    }

    @ParameterizedTest
    @MethodSource("makeSequentialItem")
    void 숫자나_사칙연산자가_연속되면_예외_발생(List<String> inputItems) {
        // when, then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> InputValidator.validate(inputItems))
                .withMessage("숫자나 사칙연산자(+, -, *, /)는 연속되어 입력될 수 없습니다");
    }

    static Stream<List<String>> makeSequentialItem() {
        return Stream.of(
                List.of("1", "-", "+"),
                List.of("1", "2", "+")
        );
    }
}
