package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatcherTest {
    @Test
    @DisplayName("find, group 메서드 테스트")
    void testMatcher() {
        //given
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//;\n1:2");
        //when
        //then
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(1)).isEqualTo(";");
        assertThat(matcher.group(2)).isEqualTo("1:2");
    }
}