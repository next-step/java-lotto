package net.chandol.splitter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void 문자하나인경우() {
        String input = "1";
        Integer result = StringCalculator.add(input);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 문자열자르고더하기() {
        Integer result = StringCalculator.add("1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 구분자가_변경되더라도_바꾸더라도_정상동작() {
        Integer result = StringCalculator.add("1,2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 옳바르지않은형식인경우_에러반환하기(){
        StringCalculator.add("1?2;3");
        Assertions.fail("여기로 오면 안됨요!!");
    }

    @Test
    public void 구분자를_명시적으로_지정() {
        Integer result = StringCalculator.add("//;\\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 점이들어가는_경우에_대한_이슈() {
        Integer result = StringCalculator.add("//.\\n1.2.3");
        assertThat(result).isEqualTo(6);
    }
}