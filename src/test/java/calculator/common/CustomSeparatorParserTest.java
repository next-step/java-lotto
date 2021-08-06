package calculator.common;

import calculator.common.CustomSeparatorParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSeparatorParserTest {

    @Test
    public void 커스텀구분자를_위한_문자열이_주어지고_커스텀구분자_파싱_시_결과를_확인한다(){
        //given
        CustomSeparatorParser parser = new CustomSeparatorParser();
        //when
        String separator = parser.parse("//;\\n");
        //then
        assertThat(separator).isEqualTo(";");
    }
}
