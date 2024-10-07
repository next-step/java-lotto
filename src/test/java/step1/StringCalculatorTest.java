package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:2+3*4/2"}, delimiter = ':')
    @DisplayName("공백을 제거하는지 확인한다")
    void 입력문자열_공백제거(String input, String expected) {
        Calculator cal = new Calculator(input);
        cal.deleteSpace();
        Assertions.assertThat(cal.getString()).isEqualTo(expected);
    }

}
