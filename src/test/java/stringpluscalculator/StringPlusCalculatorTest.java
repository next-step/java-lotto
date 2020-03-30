package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringPlusCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("계산기에 빈문자열 입력될 시 0 반환 테스트")
    void validateEmptyTest(String input) {
        assertThat(
                new StringPlusCalculator(input).calculate()
        ).isEqualTo(0);
    }

    @Test
    @DisplayName("계산 테스트")
    void calculateTest() {
        StringPlusCalculator stringPlusCalculator = new StringPlusCalculator("//;\\n1;2;3");
        assertThat(
                stringPlusCalculator.calculate()
        ).isEqualTo(6);
    }
}
