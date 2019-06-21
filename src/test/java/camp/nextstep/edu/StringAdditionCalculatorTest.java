package camp.nextstep.edu;

import camp.nextstep.edu.calculator.StringAdditionCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Java6Assertions.assertThat;

class StringAdditionCalculatorTest {
    private StringAdditionCalculator stringAdditionCalculator;

    @BeforeEach
    void setup() {
        stringAdditionCalculator = new StringAdditionCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다")
    void calculateShouldReturnZeroWhenGivenStringIsEmptyOrNull(String givenString) {
        // given
        // when
        final int actual = stringAdditionCalculator.calculate(givenString);
        // then
        assertThat(actual).isEqualTo(0);
    }
}
