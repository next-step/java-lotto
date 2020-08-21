package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator;

    @Test
    @DisplayName("값이 유효하지 않으면 0 return")
    void empty_null_0반환() {
        stringAddCalculator = new StringAddCalculator("");
        assertThat(stringAddCalculator.getResult()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "1", "8"})
    @DisplayName("숫자 한개 입력시 그대로 return")
    void 숫자_그대로_자반환(String expression) {
        stringAddCalculator = new StringAddCalculator(expression);
        assertThat(stringAddCalculator.getResult()).isEqualTo(Integer.parseInt(expression));
        
    }

    @Test
    void matcher_테스트() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//;\n1;2;3");
        assertThat(matcher.find()).isTrue();
    }

    @Test
    void 정규식_테스트() {
        String str = "1,2:3";
        assertThat(str.split("[/,:/g]").length).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("콤마,콜론 덧셈 결과")
    @CsvSource(value = {"1,2=3", "1,2,3=6", "1,2:3=6"}, delimiter = '=')
    void 덧셈_결과(String expression, int expectResult) {
        stringAddCalculator = new StringAddCalculator(expression);
        stringAddCalculator.startAddCalculation();

        assertThat(stringAddCalculator.getResult()).isEqualTo(expectResult);
    }
    @Test
    @DisplayName("custom expression 덧셈 결과")
    void custom_덧셈() {
        String expression = "//;\n1;2;3";
        stringAddCalculator = new StringAddCalculator(expression);
        stringAddCalculator.startAddCalculation();

        assertThat(stringAddCalculator.getResult()).isEqualTo(6);
    }
}
