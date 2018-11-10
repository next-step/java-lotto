package cal;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    String expression;

    @Before
    public void setUp() throws Exception {
        expression = "//;\n1;2;3";
    }

    @Test
    public void add_숫자하나() {
        int result  = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_쉼표구분자() {
        int result  = StringCalculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void add_콜론구분자() {
        int result  = StringCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }
////;\n1;2;3
    @Test
    public void 커스텀구분자() {
        int result  = StringCalculator.add(expression);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 패턴테스트() {
        int result = StringCalculator.add(expression);
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수테스트() {
        int result = StringCalculator.add("-1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void MatchTest() {
        StringExpression stringExpression = new StringExpression(expression);
        Matcher m =  stringExpression.getMatcher();
        Matcher m1 =  stringExpression.getMatcher();
//        assertThat(stringExpression.getMatcher()).isEqualTo(stringExpression.getMatcher());
        assertThat(m1.find()).isEqualTo(m.find());
        assertThat(m.group(1)).isEqualTo(m1.group(1));

    }



}