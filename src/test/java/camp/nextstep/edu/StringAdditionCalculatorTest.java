package camp.nextstep.edu;

import camp.nextstep.edu.calculator.StringAdditionCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

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

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,1",
            "2,2",
            "3,3"
    })
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void calculateShouldReturnOriginNumberWhenGivenStringIsOnlyOneNumber(String givenString, int expected) {
        // given
        // when
        final int actual = stringAdditionCalculator.calculate(givenString);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    void calculateShouldReturnSumOfNumbersWhenGivenStringIsTwoNumberSeparatedByComma() {
        // given
        final String givenString = "1,2";
        // when
        final int actual = stringAdditionCalculator.calculate(givenString);
        // then
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    void calculateShouldReturnSumOfNumbersWhenGivenStringIsTwoNumberSeparatedByCommaOrColon() {
        // given
        final String givenString = "1,2:3";
        // when
        final int actual = stringAdditionCalculator.calculate(givenString);
        // then
        assertThat(actual).isEqualTo(6);
    }
}
