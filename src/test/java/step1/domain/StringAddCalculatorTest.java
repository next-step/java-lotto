package step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    //	@Rule
//	public ExpectedException expectedExcetption = ExpectedException.none();
//
    @Test
    public void splitAndSum_nullOrBlank() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator(null);
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(0);


        StringAddCalculator stringAddCalculator2 = new StringAddCalculator("");
        result = stringAddCalculator2.splitAndSum();
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator("1");
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator("1,2");
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator("1,2:3");
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator("//;\n1;2;3");
        int result = stringAddCalculator.splitAndSum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator("-1,2,3");
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitAndSum_otherDelemeter() throws Exception {
        StringAddCalculator stringAddCalculator = new StringAddCalculator("-1,d,3");
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum())
                .isInstanceOf(RuntimeException.class);
    }
}
