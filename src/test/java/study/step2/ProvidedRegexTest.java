package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class ProvidedRegexTest {
    private Matcher matcher;

    @BeforeEach
    public void BeforeEach() {
        String text = "//;\n1;2;3";
        matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    @Test
    public void find2() {
        assertThat(matcher.find()).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자 확인")
    public void match() {
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);

            assertThat(customDelimiter).isEqualTo(";");
        }
    }

    @Test
    @DisplayName("커스텀 구분자 확인")
    public void matchAndSplit() {
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);

            assertThat(tokens).containsExactly("1", "2", "3");
        }
    }
}
