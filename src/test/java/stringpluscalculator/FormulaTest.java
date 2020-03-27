package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FormulaTest {

    @ParameterizedTest
    @CsvSource(value = {"1,-2,3,4 -> ,", "1,ㄱ,3,4 -> ,", "1,-2,3,ㄱ -> ,"}, delimiterString = " -> ")
    @DisplayName("잘못된 계산식(문자, 음수) 테스트")
    void validateTest(String input, String splitSeparators) {
        assertThatThrownBy(
                () -> new Formula(input, splitSeparators)
        ).isInstanceOf(RuntimeException.class);
    }
}
