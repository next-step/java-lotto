package calculator.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorCoreTest {

    @Test
    public void 문자분리하기_콜론() {
        String inputValue = "1:2:3";
        List<String> values = CalculatorUtils.splitInputValue(inputValue, "");
        assertThat(values).containsExactly("1", "2", "3");
    }

    @Test
    public void 문자분리하기_콤마() {
        String inputValue = "1:2:3";
        List<String> values = CalculatorUtils.splitInputValue(inputValue, "");
        assertThat(values).containsExactly("1", "2", "3");
    }

    @Test
    public void 문자분리하기_콜론콤마() {
        String inputValue = "1,2:3";
        List<String> values = CalculatorUtils.splitInputValue(inputValue, "");
        assertThat(values).containsExactly("1", "2", "3");
    }

    @Test
    public void 문자분리하기_한글자() {
        String inputValue = "1";
        List<String> values = CalculatorUtils.splitInputValue(inputValue, "");
        assertThat(values).containsExactly("1");
    }

    @Test
    public void 문자분리하기_커스텀분리자() {
        String inputValue = "//-\\n1-2-3";
        List<String> values = CalculatorUtils.splitInputValue(inputValue, "-");
        assertThat(values).containsExactly("1", "2", "3");
    }

    @Test
    public void 문자분리하기_커스텀분리자_널() {
        String inputValue = "1:2:3";
        List<String> values = CalculatorUtils.splitInputValue(inputValue, null);
        assertThat(values).containsExactly("1", "2", "3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 공백들어옴() {
        String inputValue = "";
        CalculatorUtils.isBlank(inputValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 널들어옴() {
        String inputValue = null;
        CalculatorUtils.isBlank(inputValue);
    }

    @Test
    public void 한글자들어옴() {
        String inputValue = "1";
        List<String> splitValue = CalculatorUtils.splitInputValue(inputValue, "");
        int result = CalculatorCore.sum(splitValue);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 분리된숫자더하기() {
        String[] splitValue = {"1", "2", "3"};
        int result = CalculatorCore.sum(Arrays.asList(splitValue));
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 커스텀구분자있음() {
        String inputValue = "//-\n";
        String separator = CalculatorUtils.checkCustomSeparator(inputValue);
        assertThat(separator).isEqualTo("-");
    }

    @Test
    public void 커스텀구분자없음() {
        String inputValue = "//\n";
        String separator = CalculatorUtils.checkCustomSeparator(inputValue);
        assertThat(separator).isBlank();
    }
}