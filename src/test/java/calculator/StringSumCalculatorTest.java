package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSumCalculatorTest {
    @Test
    void testSumOnlyEmptyString(){
        assertThat(StringSumCalculator.sum("")).isEqualTo(0);
    }

    @Test
    void testSumWithCommaSeparate(){
        assertThat(StringSumCalculator.sum("1,2")).isEqualTo(3);
        assertThat(StringSumCalculator.sum("1,2,3")).isEqualTo(6);
    }

    @Test
    void testSumWithCommaAndColon(){
        assertThat(StringSumCalculator.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    void testSumWithCumtomDelimitor(){
        assertThat(StringSumCalculator.sum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringSumCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringSumCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringSumCalculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringSumCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringSumCalculator.sum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
