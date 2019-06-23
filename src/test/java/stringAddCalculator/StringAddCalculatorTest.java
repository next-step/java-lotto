package stringAddCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.regex.Matcher;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringAddCalculatorTest {

    private StringAddCalculator calculator;

    @BeforeEach
    void setup() {
        calculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void add_null_또는_빈문자(String param) {
        assertThat(calculator.add(param)).isEqualTo(0);
    }

    @Test
    void add_쉼표구분자() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    void add_쉼표_또는_콜론_구분자() {
        assertThat(calculator.add("1,2:3")).isEqualTo(6);
    }

    @Test
    void add_custom_구분자() {
        assertThat(calculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void getMatcher() {
        Matcher matcher = calculator.getMatcher("//;\n1;2;3");
        assertThat(matcher.find()).isTrue();
    }

    @Test
    void getTokens() {
        Matcher matcher = calculator.getMatcher("//;\n1;2;3");
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(2)).isEqualTo("1;2;3");
    }

    @Test
    void getDelimiter() {
        Matcher matcher = calculator.getMatcher("//;\n1;2;3");
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(1)).isEqualTo(";");
    }

    @Test
    void excuteAdd() {
        int result = calculator.excuteAdd(new int[]{1, 2, 3});
        assertThat(result).isEqualTo(6);
    }

    @Test
    void arrayStringToArrayInt() {
        int[] result = calculator.arrayStringToArrayInt(new String[]{"1", "2", "3"});
        assertThat(result).contains(1, 2, 3);
    }

    @Test
    void splitString() {
        String[] result = calculator.splitString("1:2:3", ":");
        assertThat(result).contains("1", "2", "3");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrBlank(String input) {
        boolean result = calculator.isNullOrBlank(input);
        assertThat(result).isTrue();
    }
}