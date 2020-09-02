package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("Null and Empty Value")
    @ParameterizedTest
    @NullAndEmptySource
    public void split_NullAndEmpty(String val) {
        assertThat(StringCalculator.splitAndSum(val)).isEqualTo(0);
    }

    @DisplayName("one value show value")
    @Test
    public void split_OneValue() { assertThat(StringCalculator.splitAndSum("2")).isEqualTo(2); }

    @DisplayName("Comma Split And Sum")
    @Test
    public void split_Comma(){
        assertThat(StringCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @DisplayName("Semi Colon Split And Sum")
    @Test
    public void split_SemiColon(){
        assertThat(StringCalculator.splitAndSum("1:2")).isEqualTo(3);
        assertThat(StringCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("Custom Split And Sum")
    @Test
    public void split_Custom(){
        assertThat(StringCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("Negative Split And Sum")
    @Test
    public void split_Negative(){
        assertThatThrownBy(
                () -> StringCalculator.splitAndSum("-1:2,3")
        ).isInstanceOf(RuntimeException.class);
    }








}
