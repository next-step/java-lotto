package net.chandol.calculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void 문자하나인경우() {
        String input = "1";
        Integer result = StringCalculator.add(input);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 기본_자르고_더하기_테스트() {
        Integer result = StringCalculator.add("1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 빈문자열인경우_예외처리() {
        StringCalculator.add("");
    }

    @Test
    public void 구분자가_변경되더라도_바꾸더라도_정상동작() {
        Integer result = StringCalculator.add("1,2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 옳바르지않은형식인경우_에러반환하기() {
        StringCalculator.add("1?2;3");
        Assertions.fail("");
    }

    @Test
    public void 구분자를_명시적으로_지정() {
        Integer result = StringCalculator.add("//;\\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 점이들어오는경우_예외처리() {
        Integer result = StringCalculator.add("//.\\n1.2.3");
        assertThat(result).isEqualTo(6);
    }
}