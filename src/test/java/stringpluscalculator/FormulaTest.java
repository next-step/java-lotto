package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class FormulaTest {

    @ParameterizedTest
    @EmptySource
    @DisplayName("빈문자열 테스트")
    void emptyTest(String input) {
        assertThat(new Formula(input).isEmpty()).isTrue();
    }
}
