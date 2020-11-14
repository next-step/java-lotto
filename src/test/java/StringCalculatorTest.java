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
    @DisplayName("빈 문자열 확인")
    void emptyStringTest() {
        assertThat(stringCalculator.checkEmptyString("")).isTrue();
    }

    @Test
    @DisplayName("문자열 Null 확인")
    void nullCheckTest() {
        assertThat(stringCalculator.checkNullString(null)).isTrue();
    }


}