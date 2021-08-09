package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    void splitAndSum_null_또는_빈문자(String data) {
        int result = stringAddCalculator.splitAndSum(data);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.splitAndSum(data);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}