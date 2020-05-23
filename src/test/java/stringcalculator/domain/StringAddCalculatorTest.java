package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringAddCalculatorTest {

    @DisplayName("null또는 빈 문자열이 입력되면 0을 반환한다")
    @NullAndEmptySource
    @ParameterizedTest
    void nullOrEmpty(String empty) {
        long result = StringAddCalculator.execute(empty);

        assertThat(result).isEqualTo(0);
    }

}