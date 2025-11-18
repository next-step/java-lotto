package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculateTargetInputTest {

    @Test
    void 계산기의_입력값이_없는경우_예외처리를_할_수_있다() {
        assertThatThrownBy(() -> new CalculateTargetInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1 2", "&"})
    void 구분자로_나눈_입력배열의_길이가_하나이면_예외처리_할_수_있다(String input) {
        assertThatThrownBy(
                () -> new CalculateTargetInput(input).validAndSplitInput()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자로_나눈_입력배열중_짝수인덱스가_정수가_아니면_예외처리_할_수_있다() {
        assertThatThrownBy(
                () -> new CalculateTargetInput("4 + 5 * /").validAndSplitInput()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자로_나눈_입력배열중_홀수인덱스가_연산자가_아니면_예외처리_할_수_있다() {
        assertThatThrownBy(
                () -> new CalculateTargetInput("4 + 5 6 8").validAndSplitInput()
        ).isInstanceOf(IllegalArgumentException.class);
    }


}