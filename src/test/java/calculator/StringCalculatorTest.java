package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-31 22:18
 */
public class StringCalculatorTest {

//    @Test
//    void 문자열_자르기() {
//        String[] result = StringCalculator.split("5:4^2", "^");
//        assertThat(result.length).isGreaterThan(0);
//    }
//
//    @Test
//    void 커스텀구분자_추출() {
//        String customDelimiter = StringCalculator.extractCustomDelimiter("//;\n1,2:3");
//        assertThat(customDelimiter).isEqualTo(";");
//    }
//
//    @Test
//    void 커스텀문자열_제거() {
//        String result = StringCalculator.removeCustomDelimiter("//;\n1,2:3");
//        assertThat(result).isEqualTo("1,2:3");
//    }
//
    @Test
    void 더하기_쉼표_콜론() {
        int result = StringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 더하기_커스텀구분자() {
        int result = StringCalculator.add("//;\n1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "-1,a,b", ""})
    void 입력값_검증(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.add(value);
        }).withMessageMatching("0 이상의 숫자만 입력이 가능합니다.");
    }

}
