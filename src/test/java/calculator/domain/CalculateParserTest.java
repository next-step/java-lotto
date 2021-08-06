package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateParserTest {
    @Test
    public void 문자열을_받아서_디폴트_구분자로_구분하고_그_원소를_확인한다() {
        //given
        CalculateParser calculateParser = new CalculateParser();
        //when
        String[] elements = calculateParser.parse("1:2:3");
        //then
        assertThat(elements).containsExactly("1", "2", "3");
    }

    @Test
    public void 커스텀_구분자를_받아서_디폴트_구분자와_함께_원소를_파싱한다(){
        //given
        CalculateParser calculateParser = new CalculateParser();
        //when
        String[] elements = calculateParser.parse("]", "1]2:3]4");
        //then
        assertThat(elements).containsExactly("1", "2", "3", "4");
    }
}
