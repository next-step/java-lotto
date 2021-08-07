package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FormulasTest {
    @DisplayName("빈 문자열 또는 null 입력 시 size 0")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @NullAndEmptySource
    void create_ReturnEmpty_IfInputIsNullOrEmpty(String input) {
        Formulas formulas = new Formulas(input);
        assertThat(formulas.isEmpty()).isTrue();
    }

    @DisplayName("custom 구분자 입력")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource(value = {"'@', '3@4@5'", "'#', '4#7#9#2'"})
    void create_ReturnOperands_IfInputHasCustomDelimiter(String customDelimiter, String inputFormulas) {
        String input = "//" + customDelimiter + "\n" + inputFormulas;
        Formulas formulas = new Formulas(input);
        assertThat(formulas.getFormulas()).containsExactly(inputFormulas.split(customDelimiter));
    }

    @DisplayName("쉼표(,) 또는 콜론(:) 구분자를 가지는 문자열 입력")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @ValueSource(strings = {"5", "1,2,3", "3:7:8:5", "2,4:6,9:8"})
    void create_ReturnOperands_IfInputHasCommaOrColonDelimiter(String input) {
        final String delimiter = ",|:";
        Formulas formulas = new Formulas(input);
        assertThat(formulas.getFormulas()).containsExactly(input.split(delimiter));
    }

}
