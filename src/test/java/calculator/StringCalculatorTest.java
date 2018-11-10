package calculator;

import calculator.parser.CustomParser;
import calculator.parser.DefaultParser;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }


    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, stringCalculator.add(new DefaultParser(null)));
        assertEquals(0, stringCalculator.add(new DefaultParser("")));
    }

    @Test
    public void add_숫자하나() throws Exception {
        int result = stringCalculator.add(new DefaultParser("1"));
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_숫자두개() {
        int result = stringCalculator.add(new DefaultParser("1,2"));
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void add_숫자세개() {
        int result = stringCalculator.add(new DefaultParser("1,2,3"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_쉽표와콜론() {
        int result = stringCalculator.add(new DefaultParser("1,2:3"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void add_커스텀구분자() {
        int result = stringCalculator.add(new CustomParser("//;\n1;2;3"));
        assertThat(result).isEqualTo(6);
    }

    @Test(expected=RuntimeException.class)
    public void add_음수() {
        stringCalculator.add(new DefaultParser("-1,2,3"));
        stringCalculator.add(new CustomParser("-1,2,3"));
    }
}