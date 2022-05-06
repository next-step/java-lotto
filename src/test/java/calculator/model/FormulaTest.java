package calculator.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FormulaTest {

    private static final String EMPTY_INPUT_STRING = "빈 문자열은 처리할 수 없습니다.";
    private static final String NOT_MATCHED_PATTERN = "문자 규칙을 확인해주세요.";

    @ParameterizedTest
    @NullAndEmptySource
    public void 입력_문자가_빈_문자열_일때(String inputText) {
        assertThatThrownBy(() -> new Formula(inputText))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_INPUT_STRING);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2+3", "1+2 +5", "d+1,4"})
    public void 입력_문자_패턴이_올바르지_않음(String inputText) {
        assertThatThrownBy(() -> new Formula(inputText))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(NOT_MATCHED_PATTERN);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 ! 3", "1 @ 2 +5", "1 , 1 4"})
    public void 사칙_연산_기호가_아닌_경우(String inputText) {
        assertThatThrownBy(() -> new Formula(inputText))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(NOT_MATCHED_PATTERN);
    }
}
