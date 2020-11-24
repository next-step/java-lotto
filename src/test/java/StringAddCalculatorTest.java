import calculator.InputValidator;
import calculator.StringAddCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void validationInputString(String input) {
        assertThat(InputValidator.validationInputString(input)).isFalse();
    }

    @Test
    public void splitInputToIntegerArr() {
        String[] expect = {"1"};
        assertThat(StringAddCalculator.splitInputToNumberArr("1")).isEqualTo(expect);
    }

    @Test
    public void splitInputToIntegerArr_숫자두개() {
        String[] expect = {"1","2"};
        assertThat(StringAddCalculator.splitInputToNumberArr("1,2")).isEqualTo(expect);
    }

    @Test
    public void splitInputToIntegerArr_숫자세개콜론() {
        String[] expect = {"1","2","3"};
        assertThat(StringAddCalculator.splitInputToNumberArr("1,2:3")).isEqualTo(expect);
    }

    @Test
    public void splitInputToIntegerArr_숫자세개커스텀구분자() {
        String[] expect = {"1","2","3"};
        assertThat(StringAddCalculator.splitInputToNumberArr("//;\n1;2;3")).isEqualTo(expect);
    }

    @Test
    public void splitInputToIntegerArr_음수() {
        assertThatThrownBy(() -> InputValidator.validationNumbersNegative(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}