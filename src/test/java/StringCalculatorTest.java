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
        assertThat(stringCalculator.sum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열이 Null인 경우 0 리턴")
    void returnZeroNullTest() {
        assertThat(stringCalculator.sum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열에 숫자가 하나인 경우 해당 숫자 리턴")
    void returnOneNumberTest() {
        String text = "3";
        assertThat(stringCalculator.sum(text)).isEqualTo(3);
    }

}