package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    void 계산기의_입력값이_없는경우_예외처리를_할_수_있다() {
        assertThatThrownBy(() -> new InputValidator().validAndSplitInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1 2", "&"})
    void 구분자로_나눈_입력배열의_길이가_하나이면_예외처리_할_수_있다(String input) {
        assertThatThrownBy(
                () -> new InputValidator().validAndSplitInput(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자로_나눈_입력배열중_짝수인덱스가_정수가_아니면_예외처리_할_수_있다() {
        assertThatThrownBy(
                () -> new InputValidator().validAndSplitInput("4 + 5 * /")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자로_나눈_입력배열중_홀수인덱스가_연산자가_아니면_예외처리_할_수_있다() {
        assertThatThrownBy(
                () -> new InputValidator().validAndSplitInput("4 + 5 6 8")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}