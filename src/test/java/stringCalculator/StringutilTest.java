package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringutilTest {

    @Test
    @DisplayName("문자열 구분자")
    void separatorTest(){
        String inputString = "1,2;3;";
        String[] stringArray = StringUtil.complicatedSeparator(inputString);
        assertThat(stringArray).contains("1","2","3");
    }

    @Test
    @DisplayName("커스텀 구분자")
    void customSeparatorTest(){
        String customSeparatorContainString = "//a\n1a2a3";
        String[] strings = StringUtil.complicatedSeparator(customSeparatorContainString);
        assertThat(strings).contains("1","2","3");
    }

    @Test
    @DisplayName("커스텀 구분자와 쉼표, 콜론 혼합")
    void complicatedStringTest(){
        String complicatedString = "//a\n1a2,3;4";
        String[] strings = StringUtil.complicatedSeparator(complicatedString);
        assertThat(strings).contains("1","2","3","4");
    }
}
