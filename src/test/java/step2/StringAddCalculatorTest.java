package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    StringAddCalculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("null 혹은 \"\"일때 0을 리턴")
    public void nullOrEmptyStringTest() {
        String nullString = null;
        String emptyString = "";
        int nullResult = calculator.calculate(nullString);
        int emptyStringResult = calculator.calculate(emptyString);

        assertThat(nullResult).isEqualTo(0);
        assertThat(emptyStringResult).isEqualTo(0);
    }
    @ParameterizedTest
    @ValueSource(strings={"1","10"})
    @DisplayName("숫자가 하나일때 해당 숫자 리턴")
    public void singleNumberWithoutDelimiterTest(String singleNumberWithoutDelimiter) {
        int expectedResult = Integer.parseInt(singleNumberWithoutDelimiter);

        int result1 = calculator.calculate(singleNumberWithoutDelimiter);

        assertThat(result1).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value={"1,2:3","10,20;30:60"},delimiter = ':')
    @DisplayName("숫자가 두개일 경우 합을 반환한다.")
    public void numbersTest(String moreThanTwoNumbersWithDelimiter, int expectedResult) {
        int result = calculator.calculate(moreThanTwoNumbersWithDelimiter);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings={"1,2,3","1,2;3"})
    @DisplayName("쉼표,콜론으로 구분된 문자열 계산")
    public void splitWithDefaultDelimiter(String numbersWithDefaultDelimiter) {
        int result = calculator.calculate(numbersWithDefaultDelimiter);

        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings={"//w\n1w2w3","//^\n1^2^3"})
    @DisplayName("커스텀한 구분 문자열 지정하여 계산")
    public void splitWithCustomDelimiter(String numbersWithCustomDelimiter) {
        int result1 = calculator.calculate(numbersWithCustomDelimiter);
        assertThat(result1).isEqualTo(6);
    }

    @Test
    @DisplayName("pattern 학습 테스트")
    public void patternStudyTest() {
        String data = "//^\n1^2^3";
        String pattern = "//(.)\n(.*)";
        Matcher m = Pattern.compile(pattern).matcher(data);
        if(m.find()) {
            String delimiter = m.group(1);
            assertThat(delimiter).isEqualTo("^");
            String remains = m.group(2);
            assertThat(remains).isEqualTo("1^2^3");
        }
    }

    @ParameterizedTest
    @ValueSource(strings={"-1,2;3","//&\na1&2&3"})
    @DisplayName("숫자 이외의 문자나 음수일 경우 Runtime Exception")
    public void inputValidTest(String negativeNumbersOrNotNumbers) {
        assertThatThrownBy(()->calculator.calculate(negativeNumbersOrNotNumbers))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("invalid data");
    }
}
