package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step1.model.ConvertFormulaString;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConvertFormulaStringTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 연산식을 넣었을 경우 예외가 발생한다.")
    void emptyFormulaTest(String formula) {
        assertThatThrownBy(() -> new ConvertFormulaString(formula).get())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 된 연산식이 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:[2, +, 3, *, 4, /, 2]",
                        "4 / 5 * 2 + 1 - 0:[4, /, 5, *, 2, +, 1, -, 0]",
                        "5 * 3 - 1 + 4 / 1:[5, *, 3, -, 1, +, 4, /, 1]"},
            delimiter = ':')
    @DisplayName("연산식을 입력했을 경우 공백 기준으로 분리한다.")
    void formulaDivideTest(String formula, String expected) {
        String[] formulaDivided = new ConvertFormulaString(formula).get();
        assertThat(Arrays.toString(formulaDivided)).isEqualTo(expected);
    }
}
