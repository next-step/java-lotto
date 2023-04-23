package study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.util.FormulaParser;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class FormulaParserTest {

    private static final String FORMULA = "2 + 3";

    @Test
    @DisplayName("공백을 기준으로 수식을 분리한다.")
    void parseTest() {
        // Given
        FormulaParser formulaParser = new FormulaParser(FORMULA);

        // When
        final List<String> formula = formulaParser.getFormula();

        // Then
        assertThat(formula).contains("2", "+", "3");
    }

}