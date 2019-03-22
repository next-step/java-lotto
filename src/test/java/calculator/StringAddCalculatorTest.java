package calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    StringAddCalculator cal;
    List<Integer> values;

    @Before
    public void setUp() throws Exception {
        cal = new StringAddCalculator();
        values = new ArrayList<Integer>();
    }


    @Test
    public void addTest_공백_또는_Null() {

        assertThat(cal.add("")).isEqualTo(0);
        assertThat(cal.add(null)).isEqualTo(0);
    }

    @Test
    public void addTest_문자하나() {
        assertThat(cal.add("5")).isEqualTo(5);
    }

    @Test
    public void addTest_특정기호_여러숫자() {
        assertThat(cal.add("5,1,3")).isEqualTo(9);
    }

    @Test
    public void addTest_여러기호_여러숫자() {
        assertThat(cal.add("5,1:3")).isEqualTo(9);
    }

    @Test(expected = RuntimeException.class)
    public void addTest_RuntimeException() {
        assertThat(cal.add("-1,3,5")).isEqualTo(9);
    }

    @Test
    public void addTest_구분기호지정_리턴값확인() {
        assertThat(cal.split("//;\n1;2;3")).contains(1, 2, 3);
        assertThat(cal.split("2,3,4")).contains(2, 3, 4);
        assertThat(cal.split("9,3:5")).contains(9, 3, 5);
    }

    @Test
    public void addTest_최종결과값_확인() {
        assertThat(cal.add("//;\n5;1;3")).isEqualTo(9);
        assertThat(cal.add("2,3,2")).isEqualTo(7);
        assertThat(cal.add("2,3:5")).isEqualTo(10);
    }
}