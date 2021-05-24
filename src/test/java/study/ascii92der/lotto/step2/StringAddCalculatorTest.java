package study.ascii92der.lotto.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static study.ascii92der.lotto.step2.StringAddCalculator.*;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_or_empty() {
        int result = splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_one_digit() throws Exception {
        int result = splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_comma_delimiter() throws Exception {
        int result = splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_comma_or_colon_delimiter() throws Exception {
        int result = splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_delimiter() throws Exception {
        int result = splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("String split test")
    @ValueSource(strings = {"1,2,3,4,5","1:2:3:4:5"})
    void splitTest(String value) {
        assertThat(split(value).length).isEqualTo(5);
    }

    @Test
    @DisplayName("split String sum test")
    void sumTest() {
        String[] values = {"1","2","3","4","5"};
        assertThat(StringAddCalculator.sum(values)).isEqualTo(15);
    }
}