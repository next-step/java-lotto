package StringAddCalculator;

import StringAddCalculator.utils.CheckCustomDelimiter;
import org.junit.jupiter.api.Test;

import static StringAddCalculator.utils.CheckCustomDelimiter.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void matcherTest() throws Exception {
        assertThat(returnCustomDelimiter("//;\n1;2;3")).isEqualTo(";");
        assertThat(returnCustomDelimiter("//:\n1:2:3")).isEqualTo(":");
        // //와\n사이가 아닐 경우 ERROR
        assertThat(returnCustomDelimiter("/;\n1;2;3")).isEqualTo(null);
        assertThat(returnCustomDelimiter("//;1;2;3")).isEqualTo(null);
        // 원래 구분자도 계속 가능함???
//        assertThat(returnCustomDelimiter("//;\n1;2,3;4")).isEqualTo(";");
//        assertThat(returnCustomDelimiter("//;\n1,2,3,4")).isEqualTo(";");
//        assertThat(returnCustomDelimiter("//;\n1,2:3;4")).isEqualTo(";");
//        assertThat(returnCustomDelimiter("/;\n1,2,3,4")).isEqualTo(null);
    }
/*

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
   */
}