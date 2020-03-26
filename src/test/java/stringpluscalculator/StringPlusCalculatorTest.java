package stringpluscalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringPlusCalculatorTest {

    @ParameterizedTest
    @EmptySource
    @DisplayName("계산기에 빈문자열 입력될 시 0 반환 테스트")
    void validateEmptyTest(String input) {
        assertThat(new StringPlusCalculator(input).calculate()).isEqualTo(0);
    }
}
