package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest{
    private StringAddCalculator cal;
    private SplitDomain splitDomain;

    @BeforeEach
    public void setup() {
        cal = new StringAddCalculator();
        splitDomain = new SplitDomain();
    }

    @Test
    public void add_null_또는_빈문자()  {
        assertThat(cal.checkInputNumber(null)).isEqualTo(0);
        assertThat(cal.checkInputNumber("")).isEqualTo(0);
    }

    @Test
    public void add_숫자하나() throws Exception {
        assertThat(splitDomain.onlyOneInputNumber("1")).isEqualTo(1);
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        assertThat(splitDomain.basicSplitInputNumber("1,2")).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        assertThat(splitDomain.splitTokensNumber("1,2:3")).isEqualTo(6);
    }

    @Test
    public void add_custom_구분자() throws Exception {
        assertThat(splitDomain.customizeSplitInputNumber("//;\n1;2;3")).isEqualTo(6);
    }

//    @Test
//    public void add_negative() throws Exception {
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            cal.add("-1,2,3");
//        });
//    }
}