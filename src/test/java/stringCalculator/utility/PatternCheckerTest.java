package stringCalculator.utility;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PatternCheckerTest {
    @Test
    @DisplayName("커스텀구분자 ; 추출")
    void getPatternDelimiter() {
        //given
        //when
        PatternChecker patternChecker = new PatternChecker();
        patternChecker.setTextAndDelimiter("//;\n1;2;3");
        //then
        assertThat(patternChecker.getDelimiter()).isEqualTo(";");
    }

    @Test
    @DisplayName("문자 추출")
    void getPatternText() {
        //given
        //when
        PatternChecker patternChecker = new PatternChecker();
        patternChecker.setTextAndDelimiter("//;\n1;2;3");
        //then
        assertThat(patternChecker.getText()).isEqualTo("1;2;3");
    }
}