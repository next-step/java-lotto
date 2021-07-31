package stringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 구분자")
    void seperatorTest(){
        String inputString = "1,2;3;";
        String[] stringArray = StringUtil.seperator(inputString);
        Assertions.assertThat(stringArray).contains("1","2","3");
    }
}
