import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("문자열이 비어있는 경우 0 리턴")
    void returnZeroEmptyTest() {
        assertThat(stringCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열이 Null인 경우 0 리턴")
    void returnZeroNullTest() {
        assertThat(stringCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열에 숫자가 하나인 경우 해당 숫자 리턴")
    void returnOneNumberTest() {
        String text = "3";
        assertThat(stringCalculator.calculate(text)).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열에 콤마 구분자가 있을 경우 문자열 합 리턴")
    void onlyCommaDelimiterTest() {
        String text = "3,5";
        assertThat(stringCalculator.calculate(text)).isEqualTo(8);
    }

}