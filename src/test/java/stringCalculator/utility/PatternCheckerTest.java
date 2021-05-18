package stringCalculator.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PatternCheckerTest {
    @Test
    @DisplayName("커스텀구분자 //;\\n를 통하여 문자를 분리시킴")
    void isPatternMatch() {
        //given
        //when
        PatternChecker patternChecker = new PatternChecker("//;\n1;2;3");
        //then
        assertThat(patternChecker.isCustomDelimiter()).isTrue();
    }

    @Test
    @DisplayName("커스텀구분자 ; 추출")
    void getPatternDelimiter() {
        //given
        //when
        PatternChecker patternChecker = new PatternChecker("//;\n1;2;3");
        //then
        assertThat(patternChecker.isCustomDelimiter()).isTrue();
        assertThat(patternChecker.getDelimiter()).isEqualTo(";");
    }

    @Test
    @DisplayName("문자 추출")
    void getPatternText() {
        //given
        //when
        PatternChecker patternChecker = new PatternChecker("//;\n1;2;3");
        //then
        assertThat(patternChecker.isCustomDelimiter()).isTrue();
        assertThat(patternChecker.getText()).isEqualTo("1;2;3");
    }
}
