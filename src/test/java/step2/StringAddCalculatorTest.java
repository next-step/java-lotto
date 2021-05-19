package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    @DisplayName("숫자가 하나일때 해당 숫자 리턴")
    public void aNumberTest() {
        String aNumberString1 = "1";
        String aNumberString2 = "10";

        int result1 = calculator.calculate(aNumberString1);
        int result2 = calculator.calculate(aNumberString2);

        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(10);
    }

    @Test
    @DisplayName("숫자가 두개일 경우 합을 반환한다.")
    public void numbersTest() {
        String numbers1 = "1,2";
        String numbers2 = "10,20";

        int result1 = calculator.calculate(numbers1);
        int result2 = calculator.calculate(numbers2);

        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(30);
    }

    @Test
    @DisplayName("쉼표,콜론으로 구분된 문자열 계산")
    public void splitWithDefaultDelimiter() {
        String data1 = "1,2,3";
        String data2 = "1,2;3";
        int result1 = calculator.calculate(data1);
        int result2 = calculator.calculate(data2);
        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀한 구분 문자열 지정하여 계산")
    public void splitWithCustomDelimiter() {
        String data1 = "//w\n1w2w3";
        int result1 = calculator.calculate(data1);
        assertThat(result1).isEqualTo(6);
    }

    @Test
    @DisplayName("pattern 테스트")
    public void delimiterMatchesTest() {
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

    @Test
    @DisplayName("숫자 이외의 문자나 음수일 경우 Runtime Exception")
    public void inputValidTest() {
        String data1 = "-1,2,3";
        String data2 = "//&\n10a&20&30";

        assertThatThrownBy(()->{
            calculator.calculate(data1);
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("invalid data");

        assertThatThrownBy(()->{
            calculator.calculate(data2);
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("invalid data");
    }
}
