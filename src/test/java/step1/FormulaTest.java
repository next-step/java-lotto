package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FormulaTest {

    @DisplayName("get()은 입력 값 그대로 반환한다")
    @ValueSource(strings = {"1:2, 3:4, 4,5"})
    @ParameterizedTest
    void get_InputString_EqualsValue(String input) {
        Formula formula = Formula.valueOf(input);
        assertThat(formula.get()).isEqualTo(input);
    }

    @DisplayName("isBlank()는 입력 값이 빈 문자열 또는 null이면 true를 반환한다")
    @NullAndEmptySource
    @ParameterizedTest
    void isBlank_NullAndEmpty_True(String input) {
        Formula formula = Formula.valueOf(input);
        assertThat(formula.isBlank()).isTrue();
    }
}
