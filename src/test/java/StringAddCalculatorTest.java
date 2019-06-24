import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {
    private StringAddCalculator cal;

    @Test
    void 입력_값이_NULL이면_0을_리턴() {
        String input = null;
        int output = StringAddCalculator.calculator(input);
        assertThat(output).isEqualTo(0);
    }

    @Test
    void 입력_값이_빈문자열이면_0을_리턴() {
        String input = "";
        int output = StringAddCalculator.calculator(input);
        assertThat(output).isEqualTo(0);
    }

    @Test
    void 문자열_숫자_하나를_입력받으면_그대로_리턴() {
        String input = "8";
        int output = StringAddCalculator.calculator(input);
        assertThat(output).isEqualTo(Integer.parseInt(input));
    }

    @Test
    void 문자열_숫자_두개를_입력받으면_나눠_합_리턴() {
        String input = "1,2";
        int output = StringAddCalculator.calculator(input);
        assertThat(output).isEqualTo(3);
    }

    @Test
    void 문자열_숫자_세개를_입력받으면_나눠_합_리턴() {
        String input = "1,2,5";
        int output = StringAddCalculator.calculator(input);
        assertThat(output).isEqualTo(8);
    }

    @Test
    void 문자열_숫자_두개를_구분자_콜론으로_나눠_합_리턴() {
        String input = "1:2,5";
        int output = StringAddCalculator.calculator(input);
        assertThat(output).isEqualTo(8);
    }


//    @BeforeEach
//    public void setup() {
//        cal = new StringAddCalculator();
//    }
//
//    @Test
//    public void add_null_또는_빈문자() throws Exception {
//        assertThat(cal.add(null)).isEqualTo(0);
//        assertThat(cal.add("")).isEqualTo(0);
//    }
//
//    @Test
//    public void add_숫자하나() throws Exception {
//        assertThat(cal.add("1")).isEqualTo(1);
//    }
//
//    @Test
//    public void add_쉼표구분자() throws Exception {
//        assertThat(cal.add("1,2")).isEqualTo(3);
//    }
//
//    @Test
//    public void add_쉼표_또는_콜론_구분자() throws Exception {
//        assertThat(cal.add("1,2:3")).isEqualTo(6);
//    }
//
//    @Test
//    public void add_custom_구분자() throws Exception {
//        assertThat(cal.add("//;\n1;2;3")).isEqualTo(6);
//    }
//
//    @Test
//    public void add_negative() throws Exception {
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            cal.add("-1,2,3");
//        });
//    }
}
