package string_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PatternRegexTest {

    private final PatternRegex patternRegex = new PatternRegex();

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3","1:2:3", "//;\n1;2;3"})
    @DisplayName("split 테스트")
    void split(String splitData){
        assertThat(patternRegex.split(splitData)).contains("1","2","3");
    }
}